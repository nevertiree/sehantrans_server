package cn.nevertiree.business.user.userSetting.dvo;

/**
 * Created by Lance on 8/8/16.
 */
public class UserEmailVO extends UserSettingType {

    private String email;

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    int getTypeCode(){
        return UserSettingType.EMAIL;
    }

    /**取得或者修改信息*/

    public UserSettingType getInfo(UserSettingType userSettingType){
        return null;
    }

    public boolean setInfo(UserSettingType userSettingType){
        return false;
    }
}
