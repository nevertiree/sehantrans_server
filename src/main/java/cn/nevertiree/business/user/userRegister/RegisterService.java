package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.business.dao.UserbaseMapper;
import cn.nevertiree.business.dao.UserloginMapper;
import cn.nevertiree.common.RegexUtil;
import cn.nevertiree.domain.Userlogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lance Wang on 2017/1/10.
 */

@Service
public class RegisterService implements RegisterServiceIntf{

    @Autowired
    private UserloginMapper userloginMapper;
    @Autowired
    private UserbaseMapper userbaseMapper;

    public boolean initialLoginByEmail(String no, String email, String password){
        Userlogin userlogin = new Userlogin(no,email,password);
        try{
            int affectCount1 = userloginMapper.insert(userlogin);
            return (affectCount1==1);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean initialBaseByEmail(String no,String email){
        try{
            String name = RegexUtil.getNameFromEmail(email);
            int affectCount = userbaseMapper.initialByEmail(no,name,email);
            return (affectCount==1);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
