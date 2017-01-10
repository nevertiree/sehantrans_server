package cn.nevertiree.business.user.userLogin;

/**
 * Created by Lance on 7/25/16.
 */
public interface LoginServiceIntf {

    boolean hasLoginName(String name);

    boolean isRightPwd(String name, String pwd);

    boolean checkToken(String name, String token);

}
