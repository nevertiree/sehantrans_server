 /*********new method begin******/

    //本法用于检查用户的名字和密码相互匹配
    @Select({
            "select count(*) as no",
            "from userInfo",
            "where name = #{0}",
            "and pwd = #{1}"
    })
    @ResultType(Integer.class)
    int loginByPwd(String name, String pwd);

    //本法用于再注册时判断用户民是否唯一
    @Select({
            "select count(*) from userInfo",
            "where name = #{0}"
    })
    @ResultType(Integer.class)
    int checkName(String name);

    /*********new method end******/