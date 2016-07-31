package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.business.dao.UsersiteMapper;
import cn.nevertiree.common.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lance on 7/26/16.
 */

@Service
public class SettingService implements SettingServiceIntf {

    @Autowired
    UsersiteMapper usersiteMapper;

    //根据用户No查询Usersite表中的全部信息
    public UserSiteVO getUserSite(String userNo){
        return usersiteMapper.getUserSite(userNo);
    }

}