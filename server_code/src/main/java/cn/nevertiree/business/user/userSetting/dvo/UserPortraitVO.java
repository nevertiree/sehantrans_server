package cn.nevertiree.business.user.userSetting.dvo;

import java.io.File;

/**
 * Created by Lance on 8/8/16.
 */
public class UserPortraitVO extends UserSettingType {

    private File portrait;

    int getTypeCode(){
        return UserSettingType.PORTRAIT;
    }

    public File getPortrait() {
        return portrait;
    }

    public void setPortrait(File portrait) {
        this.portrait = portrait;
    }

    /**取得或者修改信息*/

    public boolean setInfo(UserSettingType userSettingType){
        return false;
    }

    public UserSettingType getInfo(UserSettingType userSettingType){
        return null;
    }

}
