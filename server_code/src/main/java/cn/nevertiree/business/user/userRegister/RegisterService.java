package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.business.dao.UserpersoninfoMapper;
import cn.nevertiree.business.dao.UsersecurityMapper;
import cn.nevertiree.business.dao.UsersiteMapper;

import cn.nevertiree.business.user.userRegister.dvo.RegisterVO;
import cn.nevertiree.business.user.userSetting.dvo.UserIntroductionVO;
import cn.nevertiree.common.IdGenerator;
import cn.nevertiree.common.JsonUtil;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lance on 7/25/16.
 */
@Service
public class RegisterService implements RegisterServiceIntf{

    @Autowired
    UsersecurityMapper usersecurityMapper;

    @Autowired
    UsersiteMapper usersiteMapper;

    @Autowired
    UserpersoninfoMapper userpersoninfoMapper;

    //检查是否有重复的名字
    public boolean hasLoginName(String name){
        return !(usersecurityMapper.hasLoginName(name)==0);
    }

    //在UserSecurity UserSite UserBaseInfo三个表中建立新用户
    public String  createUser(RegisterVO registerVO){

        //得到建立新用户之初必须要有的基本注册信息
        String no        = registerVO.getNo();
        String loginName = registerVO.getLoginName();

        //任何一个表插入失败都算全部失败
        if (usersecurityMapper.createUser(registerVO)==0){return "003";}
        if (usersiteMapper.createUser(no)==0){return "004";}
        //用注册邮箱代替用户昵称 日后可以更改
        if (userpersoninfoMapper.createUser(no,loginName,loginName)==0){return "005";}

        return "001";
    }
}
