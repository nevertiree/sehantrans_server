package cn.nevertiree.business.cart;

import cn.nevertiree.domain.Cartbase;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lance on 17-3-15.
 */

@Service
public interface CartServiceIntf {
    boolean modifyCart(String no,String cart);

    String queryProduct(List<String> item);

    boolean deleteCart(String no);

    // 提取购物车内容
    Cartbase queryCart(String no);

}
