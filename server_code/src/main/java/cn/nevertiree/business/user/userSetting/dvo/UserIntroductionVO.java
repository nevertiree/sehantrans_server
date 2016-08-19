package cn.nevertiree.business.user.userSetting.dvo;

/**
 * Created by Lance on 8/8/16.
 */
public class UserIntroductionVO extends UserSettingType {

    private byte[] introduction;

    int getTypeCode(){
        return UserSettingType.INTRODUCTION;
    }

    public byte[] getIntroduction() {
        return introduction;
    }

    public void setIntroduction(byte[] introduction) {
        this.introduction = introduction;
    }

    /**取得或者修改信息*/

    public UserSettingType getInfo(UserSettingType userSettingType){
        return null;
    }
    public boolean setInfo(UserSettingType userSettingType){
        return false;
    }
}
