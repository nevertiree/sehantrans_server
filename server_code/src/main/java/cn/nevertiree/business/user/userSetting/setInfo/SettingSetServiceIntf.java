package cn.nevertiree.business.user.userSetting.setInfo;

import cn.nevertiree.business.user.userSetting.dvo.*;

/**
 * Created by Lance on 8/9/16.
 */
public interface SettingSetServiceIntf {

    boolean setName(UserNameVO userNameVO);
    boolean setPwd(UserPwdVO userPwdVO);
    boolean setGender(UserGenderVO userGenderVO);
    boolean setBirth(UserBirthVO userBirthVO);
    boolean setMobile(UserMobileVO userMobileVO);
    boolean setEmail(UserEmailVO userEmailVO);
    boolean setSite(UserSiteVO userSiteVO);
    boolean setPortrait(UserPortraitVO userPortraitVO);
    boolean setIntroduction(UserIntroductionVO userIntroductionVO);
}
