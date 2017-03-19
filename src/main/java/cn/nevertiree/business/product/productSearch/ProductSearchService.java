package cn.nevertiree.business.product.productSearch;

import cn.nevertiree.business.dao.ProductbaseMapper;
import cn.nevertiree.domain.Productbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lance on 17-3-19.
 * */
@Service
public class ProductSearchService implements ProductSearchServiceIntf{

    @Autowired
    private ProductbaseMapper productbaseMapper;

    public List<Productbase> normalSearch(String name, String keyword, boolean isDesc) {
        if (isDesc){
            return productbaseMapper.selectByNameDesc(name,keyword);
        }else
            return productbaseMapper.selectByNameAsc(name,keyword);
    }


}
