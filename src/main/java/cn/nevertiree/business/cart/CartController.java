package cn.nevertiree.business.cart;

import cn.nevertiree.common.GenerateResponse;
import cn.nevertiree.common.JsonUtil;
import cn.nevertiree.domain.Cartbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lance on 17-3-15.
 */
@Scope("prototype")
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // 向购物车里加东西
    /***
     * http://localhost:8080/api/cart/modify?no=f744178f949243fe2f45f87fe75c42a9ce9fe1c94edf9d932bfa286453fcfa8&cart=["05daf383cbf59f21acca63110392002411b32736143cf4a795ff5afa4d56b3a","0a8be87e9e6ef0b785dd8f72948460c7c30f90d830289a7240d4d669c6c3059","e198e99554d298c4c8c1e6938c70b835cab488e78313a5ea52dee43629971a0"]
     * ***/
    @RequestMapping(value = "/modify",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String modifyCart(@RequestParam(value = "no")String no,@RequestParam(value = "cart")String cartString){
        try {
            // 从客户端查询到需要加入购物车的商品ID
            List<String> cart = (ArrayList<String>)JsonUtil.fromJson(cartString,"java.util.ArrayList");
            System.out.println(cart);
            // 从表中找到商品的详细信息
            String detail = cartService.queryProduct(cart);
            // 插入购物车表
            boolean isSuccess = cartService.modifyCart(no,detail);
            if (isSuccess)
                return GenerateResponse.generateResponse(true,"000");
            else
                return GenerateResponse.generateResponse(false,"100");
        }catch (Exception e){
            e.printStackTrace();
            return GenerateResponse.generateResponse(false,"100");
        }
    }

    // 删除购物车内容
    @RequestMapping(value = "/delete",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    /*
    * http://localhost:8080/api/cart/delete?no=f744178f949243fe2f45f87fe75c42a9ce9fe1c94edf9d932bfa286453fcfa8
    * */
    public String deleteCart(@RequestParam(value = "no")String no){
        try {
            // 获取用户ID并且删除
            boolean isSuccess = cartService.deleteCart(no);
            if (isSuccess)
                return GenerateResponse.generateResponse(true,"000");
            else
                return GenerateResponse.generateResponse(false,"100");
        }catch (Exception e){
            e.printStackTrace();
            return GenerateResponse.generateResponse(false,"100");
        }
    }

    // 查询购物车内容
    /**
     * http://localhost:8080/api/cart/query?no=f744178f949243fe2f45f87fe75c42a9ce9fe1c94edf9d932bfa286453fcfa8
     */
    @RequestMapping(value = "/query",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String queryCart(@RequestParam(value = "no")String no){
        try {
            // 获取用户ID并且查询
            Cartbase result= cartService.queryCart(no);
            if (result != null)
                return GenerateResponse.generateResponse(true,"000",result);
            else
                return GenerateResponse.generateResponse(false,"100");
        }catch (Exception e){
            e.printStackTrace();
            return GenerateResponse.generateResponse(false,"100");
        }
    }
}