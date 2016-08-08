package cn.nevertiree.business.user.userSetting.dvo;

/**
 * Created by Lance on 8/8/16.
 */
public class UserGenderVO {

    private String no;
    private String gender;
    public enum genderValue{男,女,保密};

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}