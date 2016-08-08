package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.domain.Userbaseinfo;
import cn.nevertiree.domain.Usersite;
import org.springframework.stereotype.Service;

/**
 * Created by Lance on 7/26/16.
 */
@Service
public interface SettingServiceIntf {

    //TODO 获得或者设置用户的SITE信息

    //根据用户No查询Usersite表中的全部信息
    Usersite getSiteInfo(String no);
    //更新用户的地址信息
    boolean updateSiteInfo(Usersite usersite);

    //TODO 获得或者设置用户的BaseInfo

    //根据用户No查询UserBaseInfo表中的全部信息
    Userbaseinfo getBaseInfo(String no);
    //更新用户的基本信息
    boolean updateBaseInfo(Userbaseinfo userbaseinfo);
}
