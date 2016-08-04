package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.business.dao.UserbaseinfoMapper;
import cn.nevertiree.business.dao.UsersecurityMapper;
import cn.nevertiree.business.dao.UsersiteMapper;
import cn.nevertiree.domain.Userbaseinfo;
import cn.nevertiree.domain.Usersecurity;
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
    UserbaseinfoMapper userbaseinfoMapper;

    public boolean checkName(String name){
        if (usersecurityMapper.checkName(name)==0){
            return true;
        }return false;
    }

    //在UserSecurity UserSite UserBaseInfo三个表中建立新用户
    public boolean createUser(String no, String name ,String pwd){
        //任何一个表插入失败都算全部失败
        if (usersecurityMapper.createUser(no,name,pwd)==0){return false;}
        if (userbaseinfoMapper.createUser(no)==0){return false;}
        if (usersiteMapper.createUser(no)==0){return false;}
        return true;
    }
}
