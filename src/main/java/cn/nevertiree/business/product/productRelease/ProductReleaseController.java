package cn.nevertiree.business.product.productRelease;

import cn.nevertiree.business.dao.UserbaseMapper;
import cn.nevertiree.common.GenerateResponse;
import cn.nevertiree.common.IdGenerator;
import cn.nevertiree.domain.Productbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by lance on 17-1-21.
 */

@Scope("prototype")
@Controller
@RequestMapping(value = "product")
public class ProductReleaseController {

    @Autowired
    UserbaseMapper userbaseMapper;
    @Autowired
    ProductReleaseService productReleaseService;

    @RequestMapping(value = "release")
    @ResponseBody
    public String registerProduct(@RequestParam(value = "product") String product, @RequestParam(value = "seller") String seller, @RequestParam(value = "price") double priceD,@RequestParam(value = "catalog") String catalog){

        // 从数据库中取得卖家的姓名
        String sellerName = userbaseMapper.getName(seller);
        // 根据卖家的姓名和商品的名称生成ProductNo
        String productNo = IdGenerator.getHashId(product+sellerName);
        // 把价格变成BigDecimal类
        BigDecimal price = new BigDecimal(priceD);

        // 构造VO
        Productbase productbase = new Productbase(productNo,product,seller,sellerName,0,price,catalog,"","",new Date());

        boolean isSuccess = productReleaseService.createProduct(productbase);

        if (isSuccess){
            return GenerateResponse.generateResponse(true,"100");
        }else
            return GenerateResponse.generateResponse(false,"200");


    }

}