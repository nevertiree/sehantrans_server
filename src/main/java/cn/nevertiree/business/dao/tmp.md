// initial by email
    int initialByEmail(String no,String name,String email);

    /**获取或者修改名字*/
    @Select({
            "select name",
            "from userbase",
            "where no =#{0}"
    })
    String getName(String no);

    @Update({
            "update userbase set name = #{1} where no = #{0}"
    })
    int setName(String no,String name);

    /**获取或者修改性别*/
    @Select({
            "select gender from userbase where no =#{0}"
    })
    String getGender(String no);

    @Update({
            "update userbase set gender = #{1} where no = #{0}"
    })
    int setGender(String no,String gender);

    /**获取或者修改生日*/
    @Select({
            "select birth from userbase where no =#{0}"
    })
    Date getBirth(String no);

    @Update({
            "update userbase set birth = #{1} where no = #{0}"
    })
    int setBirth(String no, Date birth);

    /**获取或者修改手机号*/
    @Select({
            "select mobile from userbase where no =#{0}"
    })
    String getMobile(String no);

    @Update({
            "update userbase set mobile = #{1} where no = #{0}"
    })
    int setMobile(String no,String mobile);

    /**获取或者修改邮箱*/
    @Select({
            "select email from userbase where no =#{0}"
    })
    String getEmail(String no);

    @Update({
            "update userbase set email = #{1} where no = #{0}"
    })
    int setEmail(String no,String email);

    /**获取或者修改照片*/
    @Select({
            "select portrait from userbase where no =#{0}"
    })
    String getPortrait(String no);

    @Select({
            "select introduction from userbase where no =#{0}"
    })
    String getIntroduction(String no);

    @Update({
            "update userbase set portrait = #{1} where no = #{0}"
    })
    int setPortrait(String no,String path);

    @Update({
            "update userbase set introduction = #{1} where no = #{0}"
    })
    int setIntroduction(String no,String path);

    //创建新用户
    @Insert({
            "insert into userPersonInfo (no,name,email)",
            "values(#{0},#{1},#{2})"
    })
    int createUser(String no, String name, String loginName);

