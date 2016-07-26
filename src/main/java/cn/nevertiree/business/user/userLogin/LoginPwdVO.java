package cn.nevertiree.business.user.userLogin;

/**
 * Created by Lance on 7/25/16.
 */
public class LoginPwdVO {
    //以password方式登录时输入的信息
    private String name;
    private String pwd;
    private String token;
    private String ip;

    public String getIp() {return ip;}
    public void setIp(String ip) {this.ip = ip;}

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

    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}

}