package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.business.dao.UserbaseinfoMapper;
import cn.nevertiree.business.dao.UsersiteMapper;
import cn.nevertiree.common.JsonUtil;
import cn.nevertiree.domain.Userbaseinfo;
import cn.nevertiree.domain.Usersite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lance on 7/26/16.
 */

@Service
public class SettingService implements SettingServiceIntf {

    @Autowired
    UsersiteMapper usersiteMapper;

    @Autowired
    UserbaseinfoMapper userbaseinfoMapper;
    //TODO 获得或者设置用户的SITE信息

    //根据用户No查询Usersite表中的全部信息
    public Usersite getSiteInfo(String no){
        return usersiteMapper.selectByPrimaryKey(no);
    }

    //更新用户的地址信息
    public boolean updateSiteInfo(Usersite usersite){
        if (usersiteMapper.updateByPrimaryKey(usersite)==0){
            return false;
        }else return true;
    }

    //TODO 获得或者设置用户的BaseInfo

    //根据用户No查询UserBaseInfo表中的全部信息
    public Userbaseinfo getBaseInfo(String no){
        return userbaseinfoMapper.selectByPrimaryKey(no);
    }

    //更新用户的基本信息
    public boolean updateBaseInfo(Userbaseinfo userbaseinfo){
        if (userbaseinfoMapper.updateByPrimaryKey(userbaseinfo)==0){
            return false;
        }else
            return true;
    }
}