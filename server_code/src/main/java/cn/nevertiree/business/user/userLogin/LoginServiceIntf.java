package cn.nevertiree.business.user.userLogin;

/**
 * Created by Lance on 7/25/16.
 */
public interface LoginServiceIntf {

    public boolean checkName(String name);

    public boolean checkPwd(String name, String pwd);

    public boolean checkToken(String name,String token);

}
