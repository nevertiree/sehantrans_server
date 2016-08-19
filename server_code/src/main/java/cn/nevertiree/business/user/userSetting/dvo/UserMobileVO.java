package cn.nevertiree.business.user.userSetting.dvo;

/**
 * Created by Lance on 8/8/16.
 */
public class UserMobileVO extends UserSettingType {

    private int mobile;

    int getTypeCode(){
        return UserSettingType.MOBILE;
    }

    public int getMobile() {
        return mobile;
    }


    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    /**取得或者修改信息*/

    public UserSettingType getInfo(UserSettingType userSettingType){
        return null;
    }

    public boolean setInfo(UserSettingType userSettingType){
        return false;
    }
}
