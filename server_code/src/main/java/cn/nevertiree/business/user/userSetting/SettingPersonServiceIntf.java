package cn.nevertiree.business.user.userSetting;

import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by Lance on 8/8/16.
 */

@Service
public interface SettingPersonServiceIntf {

    //取得与修改用户头像
    File getUserPortait(String no);
    boolean updateUserPortait(String no ,File portait);

    //取得与修改用户自我介绍
    byte[] getUserIntroduction(String no);
    boolean updateUserIntroduction(String no,byte[] introduction);

}
