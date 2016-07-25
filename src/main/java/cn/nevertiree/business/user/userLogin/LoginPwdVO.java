package cn.nevertiree.business.user.userLogin;

/**
 * Created by Lance on 7/25/16.
 */
public class LoginPwdVO {
    //以password方式登录时输入的信息
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
