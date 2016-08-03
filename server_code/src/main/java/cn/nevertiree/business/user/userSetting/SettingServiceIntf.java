package cn.nevertiree.business.user.userSetting;

/**
 * Created by Lance on 7/26/16.
 */
public interface SettingServiceIntf {

    UserSiteVO getUserSite(String userNo);

    boolean checkByNo(String userNo);

}
