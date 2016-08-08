package cn.nevertiree.business.dao;

import cn.nevertiree.domain.Userpersoninfo;
import org.apache.ibatis.annotations.*;

public interface UserpersoninfoMapper {
    /*****************New Method Begin****************************/

    //根据用户no查询用户存储picture的地址
    @Select({
            "select picture ",
            "from userPersonInfo",
            "where no = #{0}"
    })
    @ResultType(String.class)
    String getPicturePath(String no);

    //根据用户no查询用户存储introduction的地址
    @Select({
            "select introduction",
            "from userPersonInfo",
            "where no = #{0}"
    })
    @ResultType(String.class)
    String getIntroductionPath(String no);

    /*****************New Method End******************************/

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userPersonInfo
     *
     * @mbggenerated
     */
    @Delete({
        "delete from userPersonInfo",
        "where no = #{no,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userPersonInfo
     *
     * @mbggenerated
     */
    @Insert({
        "insert into userPersonInfo (no, picture, ",
        "introduction)",
        "values (#{no,jdbcType=CHAR}, #{picture,jdbcType=VARCHAR}, ",
        "#{introduction,jdbcType=VARCHAR})"
    })
    int insert(Userpersoninfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userPersonInfo
     *
     * @mbggenerated
     */
    int insertSelective(Userpersoninfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userPersonInfo
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "no, picture, introduction",
        "from userPersonInfo",
        "where no = #{no,jdbcType=CHAR}"
    })
    @ResultMap("BaseResultMap")
    Userpersoninfo selectByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userPersonInfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Userpersoninfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userPersonInfo
     *
     * @mbggenerated
     */
    @Update({
        "update userPersonInfo",
        "set picture = #{picture,jdbcType=VARCHAR},",
          "introduction = #{introduction,jdbcType=VARCHAR}",
        "where no = #{no,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Userpersoninfo record);
}