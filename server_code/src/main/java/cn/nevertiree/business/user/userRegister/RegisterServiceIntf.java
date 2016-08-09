package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.business.user.userRegister.dvo.RegisterVO;

/**
 * Created by Lance on 7/25/16.
 */
public interface RegisterServiceIntf {

    String createUser(RegisterVO registerVO);
}
