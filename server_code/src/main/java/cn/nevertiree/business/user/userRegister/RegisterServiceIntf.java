package cn.nevertiree.business.user.userRegister;

/**
 * Created by Lance on 7/25/16.
 */
public interface RegisterServiceIntf {

    boolean checkName(String name);

    boolean createUser(String no, String name , String pwd);
}
