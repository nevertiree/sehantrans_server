 /*****************新方法***开始处*****2016-07-31***********************************/

    @Insert({
            "insert into UserBaseInfo (no)",
            "values( #{0} )"
    })
    int createUser(String no);

    /*****************新方法***结束处*****2016-07-31***********************************/
    
 userpersoninfoMapper
    
        /*******new method begin ************/
    
        /**获取或者修改名字*/
        @Select({
                "select name",
                "from userPersonInfo",
                "where no =#{0}"
        })
        String getName(String no);
    
        @Update({
                "update userPersonInfo",
                "set name = #{name,jdbcType=VARCHAR},",
                "where no = #{no,jdbcType=CHAR}"
        })
        int setName(UserNameVO userNameVO);
    
        /**获取或者修改性别*/
        @Select({
                "select gender",
                "from userPersonInfo",
                "where no =#{0}"
        })
        String getGender(String no);
    
        @Update({
                "update userPersonInfo",
                "set gender = #{gender,jdbcType=SET},",
                "where no = #{no,jdbcType=CHAR}"
        })
        int setGender(UserGenderVO userGenderVO);
    
        /**获取或者修改生日*/
        @Select({
                "select gender",
                "from userPersonInfo",
                "where no =#{0}"
        })
        Timestamp getBirth(String no);
    
        @Update({
                "update userPersonInfo",
                "set birth = #{birth,jdbcType=DATETIME},",
                "where no = #{no,jdbcType=CHAR}"
        })
        int setBirth(UserBirthVO userBirthVO);
    
        /**获取或者修改手机号*/
        @Select({
                "select mobile",
                "from userPersonInfo",
                "where no =#{0}"
        })
        int  getMobile(String no);
    
        @Update({
                "update userPersonInfo",
                "set mobile = #{mobile,jdbcType=INT},",
                "where no = #{no,jdbcType=CHAR}"
        })
        int setMobile(UserMobileVO userMobileVO);
    
        /**获取或者修改邮箱*/
        @Select({
                "select email",
                "from userPersonInfo",
                "where no =#{0}"
        })
        String getEmail(String no);
    
        @Update({
                "update userPersonInfo",
                "set email = #{email,jdbcType=VARCHAR},",
                "where no = #{no,jdbcType=CHAR}"
        })
        int setEmail(UserEmailVO userEmailVO);
    
        /**获取或者修改照片*/
        @Select({
                "select portrait",
                "from userPersonInfo",
                "where no =#{0}"
        })
        String getPortrait(String no);
    
        @Select({
                "select introduction",
                "from userPersonInfo",
                "where no =#{0}"
        })
        String getIntroduction(String no);
    
        @Update({
                "update userPersonInfo",
                "set name = #{name,jdbcType=VARCHAR},",
                "where no = #{no,jdbcType=CHAR}"
        })
        int setPortrait(UserPortraitVO userPortraitVO);
    
        @Update({
                "update userPersonInfo",
                "set name = #{name,jdbcType=VARCHAR},",
                "where no = #{no,jdbcType=CHAR}"
        })
        int setIntroduction(UserIntroductionVO userIntroductionVO);
    
        //创建新用户
        @Insert({
                "insert into userPersonInfo (no,name,email)",
                "values(#{0},#{1},#{2})"
        })
        int createUser(String no, String name, String loginName);
    
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
  
  UsersecurityMapper
  
      //创建新用户
      @Insert({
              "insert into userSecurity (no, loginName, ",
              "pwd, token, ip)",
              "values (#{no,jdbcType=CHAR}, #{loginname,jdbcType=VARCHAR}, ",
              "#{pwd,jdbcType=VARCHAR}, #{token,jdbcType=CHAR}, #{ip,jdbcType=CHAR})"    })
      @ResultType(Integer.class)
      int createUser(RegisterVO registerVO);
  
      //本法用于再注册时判断用户民是否唯一
      @Select({
              "select count(*) ",
              "from userSecurity",
              "where loginName = #{0}"
      })
      @ResultType(Integer.class)
      int hasLoginName(String name);
  
      //本法用于检查用户的名字和密码
      @Select({
              "select count(*)",
              "from userSecurity",
              "where loginName = #{0}",
              "and pwd = #{1}"
      })
      @ResultType(Integer.class)
      int isRightPwd(String name, String pwd);
  
      @Update({
              "update userSecurity",
              "set pwd = #{pwd,jdbcType=VARCHAR},",
              "where no = #{no,jdbcType=CHAR}"
      })
      int setPwd(UserPwdVO userPwdVO);
  
      /**获取或者修改密码*/
      @Select({
              "select pwd",
              "from userSecurity",
              "where no =#{0}"
      })
      String getPwd(String no);
  
      //本法用于检查用户的token
      @Select({
              "select count(*) as no",
              "from userSecurity",
              "where loginName = #{0}",
              "and token = #{1}"
      })
      @ResultType(Integer.class)
      int checkToken(String name, String token);
  
      //本法用于成功登录后更新token
      @Update({
              "update userSecurity",
              "set token = #{1}",
              "where loginName = #{0}"
      })
      int updateToken(String name, String token);

UsersiteMapper

    @Insert({
            "insert into userSite (no)",
            "values( #{0} )"
    })
    int createUser(String no);

    @Update({
            "update userSite",
            "set province = #{province,jdbcType=VARCHAR},",
            "city = #{city,jdbcType=VARCHAR},",
            "county = #{county,jdbcType=VARCHAR},",
            "district = #{district,jdbcType=VARCHAR},",
            "street = #{street,jdbcType=VARCHAR},",
            "school = #{school,jdbcType=VARCHAR}",
            "where no = #{no,jdbcType=CHAR}"
    })
    int setSite(UserSiteVO userSiteVO);

    @Select({
            "select",
            "no, province, city, county, district, street, school",
            "from userSite",
            "where no = #{no,jdbcType=CHAR}"
    })
    @ResultType(UserSiteVO.class)
    UserSiteVO getSite(String no);
