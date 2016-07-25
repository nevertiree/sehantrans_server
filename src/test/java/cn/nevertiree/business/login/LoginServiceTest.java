package cn.nevertiree.business.login;

import cn.nevertiree.business.user.userLogin.LoginService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Lance on 7/25/16.
 */
public class LoginServiceTest {

    @Autowired
    LoginService loginService;

    @Test
    public void testLoginByPwd(){
        boolean excepted = true;
        boolean actual =loginService.loginByPwd("wlx","wlx");
        Assert.assertEquals(excepted,actual);
    }
}
