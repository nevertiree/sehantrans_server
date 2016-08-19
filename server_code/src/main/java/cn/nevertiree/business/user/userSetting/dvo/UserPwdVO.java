package cn.nevertiree.business.user.userSetting.dvo;

/**
 * Created by Lance on 8/8/16.
 */
public class UserPwdVO extends UserSettingType {

    private String pwd;

    int getTypeCode(){
        return UserSettingType.PWD;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**取得或者修改信息*/

    public UserSettingType getInfo(UserSettingType userSettingType){
        return null;
    }

    public boolean setInfo(UserSettingType userSettingType){
        return false;
    }

}
