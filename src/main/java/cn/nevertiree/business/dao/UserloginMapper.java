package cn.nevertiree.business.dao;

import cn.nevertiree.domain.Userlogin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
public interface UserloginMapper {

    //本法用于再注册时判断用户民是否唯一
    @Select({
            "select count(*) ",
            "from userlogin",
            "where username = #{0}"
    })
    @ResultType(Integer.class)
    int hasLoginName(String name);

    //本法用于检查用户的名字和密码 如果正确则返回no
    @Select({
            "select no",
            "from userlogin",
            "where username = #{0}",
            "and password = #{1}"
    })
    @ResultType(String.class)
    String isRightPwd(String name, String pwd);

    /**获取密码*/
    @Select({
            "select password",
            "from userlogin",
            "where no =#{0}"
    })
    String getPwd(String no);

    /**修改密码**/
    @Update({
            "update userlogin set password = #{1} where no = #{0}"
    })
    int updatePassword(String no,String password);

    /**修改邮箱**/
    @Update({
            "update userlogin set username= #{1} where no = #{0}"
    })
    int setEmail(String no,String email);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated
     */
    @Delete({
        "delete from userlogin",
        "where no = #{no,jdbcType=CHAR}"
    })
    int deleteByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated
     */
    @Insert({
        "insert into userlogin (no, username, ",
        "password)",
        "values (#{no,jdbcType=CHAR}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR})"
    })
    int insert(Userlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated
     */
    int insertSelective(Userlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "no, username, password",
        "from userlogin",
        "where no = #{no,jdbcType=CHAR}"
    })
    @ResultMap("cn.nevertiree.business.dao.UserloginMapper.BaseResultMap")
    Userlogin selectByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Userlogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userlogin
     *
     * @mbg.generated
     */
    @Update({
        "update userlogin",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR}",
        "where no = #{no,jdbcType=CHAR}"
    })
    int updateByPrimaryKey(Userlogin record);
}