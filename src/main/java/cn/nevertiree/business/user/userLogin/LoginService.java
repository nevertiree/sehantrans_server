package cn.nevertiree.business.user.userLogin;

import cn.nevertiree.business.dao.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lance on 7/25/16.
 */

@Service
public class LoginService implements LoginServiceIntf{

    @Autowired
    UserinfoMapper userinfoMapper;

    //输入用户名和密码
    public boolean loginByPwd(String name ,String pwd){
        //密码和用户名同时符合的结果条数（通常不是0就是1)为零就说明登录fail
        if (userinfoMapper.loginByPwd(name,pwd)==0){
            return false;//返回标记符改成false
        }
        return true;
    }

}
