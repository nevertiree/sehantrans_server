package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.business.user.userSetting.dvo.UserSettingType;
import org.springframework.stereotype.Service;

/**
 * Created by Lance on 8/15/16.
 *取得或者修改用户信息
*/

@Service
public class SettingService implements SettingServiceIntf {

    public UserSettingType getInfo(UserSettingType userSettingType) throws Exception {
        return userSettingType.getInfo(userSettingType);//传入一个类型
    }

    public boolean setInfo(UserSettingType userSettingType) throws Exception{
        return userSettingType.setInfo(userSettingType);
    }

}
