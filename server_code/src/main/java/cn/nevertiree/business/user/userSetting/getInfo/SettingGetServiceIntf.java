package cn.nevertiree.business.user.userSetting.getInfo;

import cn.nevertiree.business.user.userSetting.dvo.UserSiteVO;

import java.io.File;
import java.sql.Timestamp;

/**
 * Created by Lance on 8/9/16.
 */


public interface SettingGetServiceIntf {

    String getName(String no);
    String getPwd(String no);
    String getGender(String no);
    Timestamp getBirth(String no);
    int getMobile(String no);
    String getEmail(String no);
    UserSiteVO getSite(String no);
    File getPortrait(String no);
    byte[] getIntroduction(String no);
}
