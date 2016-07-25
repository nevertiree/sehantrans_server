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

    //符合登录条件的帐号个数（非0即1）
    private int validNum;
    private boolean successLogin=false;//返回标记符

    //输入用户名和密码
    public boolean loginByPwd(String name ,String pwd){
//return new java.util.Random().nextBoolean();
        //密码和用户名同时符合的结果条数（通常不是0就是1）
        validNum=userinfoMapper.loginByPwd(name,pwd);
        //如果结果非零就说明登录验证成功
        if (validNum>0){
            successLogin=true;//返回标记符改成true
        }
        return successLogin;
    }

}
