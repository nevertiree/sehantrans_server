package cn.nevertiree.business.dao;

import cn.nevertiree.domain.Usersecurity;
import org.apache.ibatis.annotations.*;

public interface UsersecurityMapper {

    /*********new method begin******/

    //本法用于再注册时判断用户民是否唯一
    @Select({
            "select count(*) from userSecurity",
            "where name = #{0}"
    })
    @ResultType(Integer.class)
    int checkName(String name);

    //本法用于检查用户的名字和密码
    @Select({
            "select count(*) as no",
            "from userSecurity",
            "where name = #{0}",
            "and pwd = #{1}"
    })
    @ResultType(Integer.class)
    int checkPwd(String name, String pwd);


    //本法用于检查用户的token
    @Select({
            "select count(*) as no",
            "from userSecurity",
            "where name = #{0}",
            "and token = #{1}"
    })
    @ResultType(Integer.class)
    int checkToken(String name,String token);

    //本法用于成功登录后更新token
    @Update({
            "update userSecurity",
            "set token = #{1}",
            "where name = #{0}"
    })
    int updateToken(String name,String token);


    //创建新用户
    @Insert({
            "insert into UserSecurity (no,name,pwd)",
            "values(#{0},#{1},#{2})"
    })
    int createUser(String no ,String name ,String pwd);

    /*********new method end******/



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSecurity
     *
     * @mbggenerated
     */
    @Delete({
        "delete from userSecurity",
        "where no = #{no,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSecurity
     *
     * @mbggenerated
     */
    @Insert({
        "insert into userSecurity (no, name, ",
        "pwd, token, ip)",
        "values (#{no,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{pwd,jdbcType=VARCHAR}, #{token,jdbcType=VARCHAR}, #{ip,jdbcType=VARCHAR})"
    })
    int insert(Usersecurity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSecurity
     *
     * @mbggenerated
     */
    int insertSelective(Usersecurity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSecurity
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "no, name, pwd, token, ip",
        "from userSecurity",
        "where no = #{no,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    Usersecurity selectByPrimaryKey(String no);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSecurity
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Usersecurity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userSecurity
     *
     * @mbggenerated
     */
    @Update({
        "update userSecurity",
        "set name = #{name,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "token = #{token,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR}",
        "where no = #{no,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Usersecurity record);
}