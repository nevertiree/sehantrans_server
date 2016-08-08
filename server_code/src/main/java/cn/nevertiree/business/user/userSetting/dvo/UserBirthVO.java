package cn.nevertiree.business.user.userSetting.dvo;

import java.sql.Timestamp;

/**
 * Created by Lance on 8/8/16.
 */
public class UserBirthVO {

    private String    no;
    private Timestamp birth;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }
}
