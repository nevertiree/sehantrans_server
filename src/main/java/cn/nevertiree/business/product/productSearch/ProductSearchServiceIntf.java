package cn.nevertiree.business.product.productSearch;

import cn.nevertiree.domain.Productbase;

import java.util.List;

/**
 * Created by lance on 17-3-19.
 */
public interface ProductSearchServiceIntf {
    List<Productbase> normalSearch(String name, String keyword, boolean isDesc);
}
