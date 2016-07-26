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

    //输入用户名和密码
    public boolean checkPwd(String name ,String pwd){
        //密码和用户名同时符合的结果条数（通常不是0就是1)为零就说明登录fail
        if (usersecurityMapper.checkPwd(name,pwd)==0){
            return false;//返回标记符改成false
        }
        return true;
    }

    public boolean checkName(String name){
        if (usersecurityMapper.checkName(name)==0){
            return false;//查无此人 返回错误--说明用户名不存在
        }
        return true;
    }

    public boolean checkToken(String name,String token){
        if (usersecurityMapper.checkToken(name,token)==0){
            return false;
        }
        return true;
    }

}
