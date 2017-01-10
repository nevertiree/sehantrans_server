package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.domain.Userlogin;
import org.springframework.stereotype.Service;

/**
 * Created by Lance Wang on 2017/1/10.
 */

@Service
public interface RegisterServiceIntf {

    boolean initialLoginByEmail(String no, String email, String password);

    boolean initialBaseByEmail(String no,String email);



}
