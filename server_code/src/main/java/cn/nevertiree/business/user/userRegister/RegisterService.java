package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.business.dao.UserpersoninfoMapper;
import cn.nevertiree.business.dao.UsersecurityMapper;
import cn.nevertiree.business.dao.UsersiteMapper;

import cn.nevertiree.business.user.userRegister.dvo.RegisterVO;
import cn.nevertiree.business.user.userSetting.dvo.UserIntroductionVO;
import cn.nevertiree.common.IdGenerator;
import cn.nevertiree.common.JsonUtil;
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

    //在UserSecurity UserSite UserBaseInfo三个表中建立新用户
    public String  createUser(RegisterVO registerVO){

        //得到建立新用户之初必须要有的基本注册信息
        String name = registerVO.getName();
        String loginName =registerVO.getLoginName();
        String pwd =registerVO.getPwd();

        //判断loginName是否重复
        if (usersecurityMapper.checkName(loginName)==0) return "002";

        //根据用户的注册码得到唯一的userNo
        String no = IdGenerator.getHashId(loginName);
        registerVO.setNo(no);

        //任何一个表插入失败都算全部失败
        if (usersecurityMapper.createUser(no,name,pwd)==0){return "003";}
        if (usersiteMapper.createUser(no)==0){return "004";}
        if (userpersoninfoMapper.createUser(no,name,loginName)==0){return "005";}

        return "001";
    }
}
