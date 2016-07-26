package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.business.dao.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lance on 7/25/16.
 */
@Service
public class RegisterService implements RegisterServiceIntf{

    @Autowired
    UserinfoMapper userinfoMapper;

    public boolean checkName(String name){
        if (userinfoMapper.checkName(name)==0){
            return true;
        }return false;
    }

}
