package cn.nevertiree.business.dao;

import cn.nevertiree.domain.Productbase;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public interface ProductbaseMapper {

    //1. 修改商品名称
    @Update({
        "update productbase set name = #{1} where no = #{0};"
    })
    int modifyName(String no,String name);
    //2. 修改商品数量
    @Update({
            "update productbase set quantity = #{1} where no = #{0};"
    })
    int modifyQuantity(String no,int quantity);
    //3. 修改商品价格
    @Update({
            "update productbase set price = #{1} where no = #{0};"
    })
    int modifyPrice(String no, BigDecimal price);
    //4. 修改商品类别
    @Update({
            "update productbase set catalog = #{1} where no = #{0};"
    })
    int modifyCatalog(String no,String catalog);

    //5.根据商品名字和排序关键字降序查找
//    @Select({
//            "select * from productbase where name regexp #{0} order by #{1} desc limit 0,100;"
//    })
//    @ResultMap("cn.nevertiree.business.dao.ProductbaseMapper.BaseResultMap")
    List<Productbase> selectByNameDesc(String name, String keyword);
    // 根据名字升序查找
//    @Select({
//            "select * from productbase where name regexp #{0} order by #{1} limit 0,100;"
//    })
//    @ResultMap("cn.nevertiree.business.dao.ProductbaseMapper.BaseResultMap")
    List<Productbase> selectByNameAsc(String name,String keyword);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productbase
     *
     * @mbg.generated
     */
    @Delete({
        "delete from productbase",
        "where no = #{no,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productbase
     *
     * @mbg.generated
     */
    @Insert({
        "insert into productbase (no, name, sellerNo, ",
        "sellerName, quantity, ",
        "price, catalog, ",
        "picture, introduction, ",
        "releaseTime)",
        "values (#{no,jdbcType=CHAR}, #{name,jdbcType=VARCHAR}, #{sellerno,jdbcType=CHAR}, ",
        "#{sellername,jdbcType=VARCHAR}, #{quantity,jdbcType=INTEGER}, ",
        "#{price,jdbcType=DECIMAL}, #{catalog,jdbcType=VARCHAR}, ",
        "#{picture,jdbcType=VARCHAR}, #{introduction,jdbcType=VARCHAR}, ",
        "#{releasetime,jdbcType=TIMESTAMP})"
    })
    int insert(Productbase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productbase
     *
     * @mbg.generated
     */
    int insertSelective(Productbase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productbase
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "no, name, sellerNo, sellerName, quantity, price, catalog, picture, introduction, ",
        "releaseTime",
        "from productbase",
        "where no = #{no,jdbcType=CHAR}"
    })
    @ResultMap("cn.nevertiree.business.dao.ProductbaseMapper.BaseResultMap")
    Productbase selectByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productbase
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Productbase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table productbase
     *
     * @mbg.generated
     */
    @Update({
        "update productbase",
        "set name = #{name,jdbcType=VARCHAR},",
          "sellerNo = #{sellerno,jdbcType=CHAR},",
          "sellerName = #{sellername,jdbcType=VARCHAR},",
          "quantity = #{quantity,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DECIMAL},",
          "catalog = #{catalog,jdbcType=VARCHAR},",
          "picture = #{picture,jdbcType=VARCHAR},",
          "introduction = #{introduction,jdbcType=VARCHAR},",
          "releaseTime = #{releasetime,jdbcType=TIMESTAMP}",
        "where no = #{no,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Productbase record);
}