package cn.nevertiree.business.product.productRelease;

import cn.nevertiree.business.dao.ProductbaseMapper;
import cn.nevertiree.domain.Productbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lance on 17-1-21.
 */

@Service
public class ProductReleaseService implements ProductReleaseServiceIntf {

    @Autowired
    private ProductbaseMapper productbaseMapper;

    public boolean createProduct(Productbase productbase){
        return (productbaseMapper.insert(productbase)==1);
    }
}
