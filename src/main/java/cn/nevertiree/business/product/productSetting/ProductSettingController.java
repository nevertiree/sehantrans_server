package cn.nevertiree.business.product.productSetting;

import cn.nevertiree.common.GenerateResponse;
import cn.nevertiree.domain.Productbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * Created by lance on 17-1-22.
 */

@Scope("prototype")
@Controller
@RequestMapping(value = "/product/setting")
public class ProductSettingController {

    @Autowired
    private ProductSettingService productSettingService;

    //0. 取得商品信息
    @RequestMapping(value = "/baseinfo",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getBaseInfo(@RequestParam(value = "no") String no){
        Productbase productbase = productSettingService.getBaseInfo(no);
        if (productbase!=null){
            return GenerateResponse.generateResponse(true,"100",productbase);
        }else {
            return GenerateResponse.generateResponse(false,"200");
        }
    }

    //1. 修改商品名称
    @RequestMapping(value = "/name",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String modifyName(@RequestParam(value = "no")String no, @RequestParam(value = "name")String name){
        boolean isSuccess = productSettingService.modifyName(no,name);
        if (isSuccess){
            return GenerateResponse.generateResponse(true,"100");
        }else {
            return GenerateResponse.generateResponse(false,"200");
        }
    }

    //2. 修改商品数量
    @RequestMapping(value = "/quantity",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String modifyQuantity(@RequestParam(value = "no")String no, @RequestParam(value = "quantity")int quantity){
        boolean isSuccess = productSettingService.modifyQuantity(no,quantity);
        if (isSuccess){
            return GenerateResponse.generateResponse(true,"100");
        }else {
            return GenerateResponse.generateResponse(false,"200");
        }
    }

    //3. 修改商品价格
    @RequestMapping(value = "/price",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String modifyPrice(@RequestParam(value = "no")String no, @RequestParam(value = "price")String price){
        boolean isSuccess = productSettingService.modifyPrice(no,new BigDecimal(price));
        if (isSuccess){
            return GenerateResponse.generateResponse(true,"100");
        }else {
            return GenerateResponse.generateResponse(false,"200");
        }
    }

    //4. 修改商品类别
    @RequestMapping(value = "/catalog",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String modifyCatalog(@RequestParam(value = "no")String no, @RequestParam(value = "catalog")String catalog){
        boolean isSuccess = productSettingService.modifyCatalog(no,catalog);
        if (isSuccess){
            return GenerateResponse.generateResponse(true,"100");
        }else {
            return GenerateResponse.generateResponse(false,"200");
        }
    }

    //5. 删除商品
    @RequestMapping(value = "/delete",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteProduct(@RequestParam(value = "no") String no){
        boolean isSuccess = productSettingService.deleteProduct(no);
        if (isSuccess){
            return GenerateResponse.generateResponse(true,"100");
        }else {
            return GenerateResponse.generateResponse(false,"200");
        }
    }

}
