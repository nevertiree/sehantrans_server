package cn.nevertiree.business.user.userSetting;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Lance Wang on 2017/1/10.
 */

@Component
public interface SettingServiceIntf {

    boolean modifyPassword(String no,String password);

    boolean modifyName(String no,String name);

    boolean modifyGender(String no,String gender);

    boolean modifyBirth(String no, Date date);

}
