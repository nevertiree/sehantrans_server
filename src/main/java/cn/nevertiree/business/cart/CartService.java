package cn.nevertiree.business.cart;

import cn.nevertiree.business.dao.CartbaseMapper;
import cn.nevertiree.business.dao.ProductbaseMapper;
import cn.nevertiree.domain.Cartbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.nevertiree.common.JsonUtil.toJson;

/**
 * Created by lance on 17-3-15.
 */
@Service
public class CartService implements CartServiceIntf{

    @Autowired
    private ProductbaseMapper productbaseMapper;
    @Autowired
    private CartbaseMapper cartbaseMapper;

    // 把String插入Cart
    public boolean modifyCart(String no,String cart){
        Cartbase cartbase = new Cartbase(no,cart);
        try {
            int affect = cartbaseMapper.insert(cartbase);
            return affect != 0;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    // 先从product表中查出相应的商品信息列表
    public String queryProduct(List<String> item){
        try {
            return toJson(productbaseMapper.selectBatchById(item));
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    // 删除购物车内容
    public boolean deleteCart(String no){
        try {
            cartbaseMapper.deleteByPrimaryKey(no);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    // 提取购物车内容
    public Cartbase queryCart(String no){
        try {
            return cartbaseMapper.selectByPrimaryKey(no);
        }catch (Exception e){
            return null;
        }
    }


}
