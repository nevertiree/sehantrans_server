package cn.nevertiree.business.user.userRegister.dvo;

/**
 * Created by Lance on 8/9/16.
 */

//建立新用户之初必须要有的基本注册信息
public class RegisterVO {

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
