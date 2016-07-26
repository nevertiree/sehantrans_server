package cn.nevertiree.business.user.userLogin;

/**
 * Created by Lance on 7/25/16.
 */
public interface LoginServiceIntf {

    public boolean checkName(String name);

    //输入用户名和密码
    public boolean checkPwd(String name, String pwd);

    public boolean checkToken(String name,String token);

}
