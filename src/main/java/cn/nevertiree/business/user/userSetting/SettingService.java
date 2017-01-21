package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.business.dao.UserbaseMapper;
import cn.nevertiree.business.dao.UserloginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Lance Wang on 2017/1/10.
 */
@Service
public class SettingService implements SettingServiceIntf{

    @Autowired
    UserloginMapper userloginMapper;

    @Autowired
    UserbaseMapper userbaseMapper;

    public boolean modifyPassword(String no,String password){
        try{
            userloginMapper.updatePassword(no,password);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyName(String no,String name){
        try {
            int affectCount = userbaseMapper.setName(no,name);
            return (affectCount==1);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyGender(String no,String gender){
        try {
            int affectCount = userbaseMapper.setGender(no,gender);
            return (affectCount==1);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyBirth(String no, Date date){
        try {
            int affectCount = userbaseMapper.setBirth(no,date);
            return (affectCount==1);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyMobile(String no,String tel){
        try {
            int affectCount = userbaseMapper.setMobile(no, tel);
            return (affectCount == 1);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
