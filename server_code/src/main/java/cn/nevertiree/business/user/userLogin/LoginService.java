package cn.nevertiree.business.user.userLogin;

import cn.nevertiree.business.dao.UsersecurityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lance on 7/25/16.
 */

@Service
public class LoginService implements LoginServiceIntf{

    @Autowired
    UsersecurityMapper usersecurityMapper;

    public boolean hasLoginName(String name){
        return !(usersecurityMapper.hasLoginName(name)==0);
    }

    //输入用户名和密码
    public boolean isRightPwd(String name ,String pwd){
        //密码和用户名同时符合的结果条数（通常不是0就是1)为零就说明登录fail
        return (usersecurityMapper.isRightPwd(name,pwd)==1);
    }

    public boolean checkToken(String name,String token){
        return (usersecurityMapper.checkToken(name,token)==0);
    }

}
