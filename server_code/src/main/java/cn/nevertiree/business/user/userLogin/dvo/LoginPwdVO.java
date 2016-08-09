package cn.nevertiree.business.user.userLogin.dvo;

/**
 * Created by Lance on 7/25/16.
 */
public class LoginPwdVO {
    //以password方式登录时输入的信息

    private String no;
    private String loginName;
    private String pwd;
    private String token;
    private String ip;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIp() {return ip;}
    public void setIp(String ip) {this.ip = ip;}

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {return token;}
    public void setToken(String token) {this.token = token;}

}