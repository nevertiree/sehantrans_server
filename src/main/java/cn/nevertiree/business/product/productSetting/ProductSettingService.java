package cn.nevertiree.business.product.productSetting;

import cn.nevertiree.business.dao.ProductbaseMapper;
import cn.nevertiree.domain.Productbase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

import java.math.BigDecimal;

/**
 * Created by lance on 17-1-22.
 */

@Service
public class ProductSettingService implements ProductSettingServiceIntf{

    @Autowired
    private ProductbaseMapper productbaseMapper;

//    public boolean reflect(String methodName){
//        try {
//            Class.forName("ProductbaseMapper").getMethod(methodName);
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }

    public Productbase getBaseInfo(String no){
        try {
            return productbaseMapper.selectByPrimaryKey(no);
        }catch (Exception e){
            e.fillInStackTrace();
            return null;
        }
    }

    //1. 修改商品名称
    public boolean modifyName(String no,String name){
        try {
            productbaseMapper.modifyName(no,name);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //2. 修改商品数量
    public boolean modifyQuantity(String no,int quantity){
        try {
            productbaseMapper.modifyQuantity(no,quantity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //3. 修改商品价格
    public boolean modifyPrice(String no, BigDecimal price){
        try {
            productbaseMapper.modifyPrice(no,price);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //4. 修改商品类别
    public boolean modifyCatalog(String no,String catalog){
        try {
            productbaseMapper.modifyCatalog(no,catalog);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //5. 删除商品
    public boolean deleteProduct(String no){
        try {
            productbaseMapper.deleteByPrimaryKey(no);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
