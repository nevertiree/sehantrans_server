package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.business.user.userSetting.dvo.UserSettingType;

/**取得或者修改用户信息*/

public interface SettingServiceIntf {

    UserSettingType getInfo(UserSettingType userSettingType) throws Exception;
    boolean setInfo(UserSettingType userSettingType) throws Exception;

}
