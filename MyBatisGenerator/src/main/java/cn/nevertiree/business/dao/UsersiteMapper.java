package cn.nevertiree.business.dao;

import cn.nevertiree.domain.Usersite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UsersiteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSite
     *
     * @mbggenerated
     */
    @Delete({
        "delete from userSite",
        "where no = #{no,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSite
     *
     * @mbggenerated
     */
    @Insert({
        "insert into userSite (no, province, ",
        "city, county, district, ",
        "street)",
        "values (#{no,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{county,jdbcType=VARCHAR}, #{district,jdbcType=VARCHAR}, ",
        "#{street,jdbcType=VARCHAR})"
    })
    int insert(Usersite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSite
     *
     * @mbggenerated
     */
    int insertSelective(Usersite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSite
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "no, province, city, county, district, street",
        "from userSite",
        "where no = #{no,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Usersite selectByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSite
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Usersite record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSite
     *
     * @mbggenerated
     */
    @Update({
        "update userSite",
        "set province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "county = #{county,jdbcType=VARCHAR},",
          "district = #{district,jdbcType=VARCHAR},",
          "street = #{street,jdbcType=VARCHAR}",
        "where no = #{no,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Usersite record);
}