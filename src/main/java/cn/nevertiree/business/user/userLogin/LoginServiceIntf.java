package cn.nevertiree.business.user.userLogin;

/**
 * Created by Lance on 7/25/16.
 */
public interface LoginServiceIntf {

    //输入用户名和密码 判断是可以登录
    public boolean loginByPwd(String name, String pwd);

}
