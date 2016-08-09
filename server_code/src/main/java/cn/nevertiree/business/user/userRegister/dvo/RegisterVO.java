package cn.nevertiree.business.user.userRegister.dvo;

/**
 * Created by Lance on 8/9/16.
 */

//建立新用户之初必须要有的基本注册信息
public class RegisterVO {

    private String no;
    private String name;
    private String loginName;
    private String pwd;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
