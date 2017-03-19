package cn.nevertiree.business.product.productSearch;

import cn.nevertiree.common.GenerateResponse;
import cn.nevertiree.common.JsonUtil;
import cn.nevertiree.domain.Productbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/** 商品查找功能
 *  客户端返回商品的关键字，可以按照时间和价格查询
 *  先返回100条数据 JSON格式返回全部信息
 * */

@Scope("prototype")
@Controller
@RequestMapping("/product/search")
public class ProductSearchController {

    // TODO: 17-3-19 REGEX + ORDER BY

    @Autowired
    private ProductSearchService productSearchService;

    // 常规查询法
    @RequestMapping(value = "/normal",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String searchByTime(@RequestParam(value = "name")String productName,@RequestParam(value = "keyword")String keyword,@RequestParam(value = "mode")String mode){

        List<Productbase> data;

        // 判断升序和降序
        Boolean isDesc = mode.equals("desc");
        try {
            // 根据排序方式选择算法
            if(isDesc)
                data = productSearchService.normalSearch(productName,keyword,true);
            else
                data = productSearchService.normalSearch(productName,keyword,false);
            // 包装返回的结果
            String result = JsonUtil.toJson(data);
            return GenerateResponse.generateResponse(true,"000",result);

        }catch (Exception e){
            e.printStackTrace();
            return GenerateResponse.generateResponse(false,"100");
        }

    }


}
