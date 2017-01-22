package cn.nevertiree.business.product.productSetting;

import cn.nevertiree.domain.Productbase;

import java.math.BigDecimal;

/**
 * Created by lance on 17-1-22.
 */
public interface ProductSettingServiceIntf {

    Productbase getBaseInfo(String no);
    //1. 修改商品名称
    boolean modifyName(String no,String name);
    //2. 修改商品数量
    boolean modifyQuantity(String no,int quantity);
    //3. 修改商品价格
    boolean modifyPrice(String no, BigDecimal price);
    //4. 修改商品类别
    boolean modifyCatalog(String no,String catalog);

}
