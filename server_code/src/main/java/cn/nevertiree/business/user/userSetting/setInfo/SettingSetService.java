package cn.nevertiree.business.user.userSetting.setInfo;

import cn.nevertiree.business.dao.UserpersoninfoMapper;
import cn.nevertiree.business.dao.UsersecurityMapper;
import cn.nevertiree.business.dao.UsersiteMapper;
import cn.nevertiree.business.user.userSetting.dvo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Lance on 8/9/16.
 */
@Service
public class SettingSetService implements SettingSetServiceIntf {

    @Autowired
    UsersecurityMapper usersecurityMapper;

    @Autowired
    UserpersoninfoMapper userpersoninfoMapper;

    @Autowired
    UsersiteMapper usersiteMapper;

    public boolean setName(UserNameVO userNameVO){
        return !(userpersoninfoMapper.setName(userNameVO)==0);
    }

    public boolean setPwd(UserPwdVO userPwdVO){
       return !(usersecurityMapper.setPwd(userPwdVO)==0);
    }

    public boolean setGender(UserGenderVO userGenderVO){
        return !(userpersoninfoMapper.setGender(userGenderVO)==0);
    }

    public boolean setBirth(UserBirthVO userBirthVO) {
        return !(userpersoninfoMapper.setBirth(userBirthVO)==0);
    }

    public boolean setMobile(UserMobileVO userMobileVO){
        return !(userpersoninfoMapper.setMobile(userMobileVO)==0);
    }

    public boolean setEmail(UserEmailVO userEmailVO){
        return !(userpersoninfoMapper.setEmail(userEmailVO)==0);
    }
    public boolean setSite(UserSiteVO userSiteVO){
        return !(usersiteMapper.setSite(userSiteVO)==0);
    }
    public boolean setPortrait(UserPortraitVO userPortraitVO){

        String no = userPortraitVO.getNo();

        boolean result = false;

        //TODO 设置存储图片的文件位置????不同格式？？？
        String picturePath = "var/www/data/portrait/"+no+".txt";

        /*File pictureFile = new File();

        try {
            FileOutputStream output = new FileOutputStream(pictureFile);
            output.write(portait);
            output.flush();
            output.close();
        }catch (IOException e2){
            e2.printStackTrace();
        }*/

        return result;
    }
    public boolean setIntroduction(UserIntroductionVO userIntroductionVO){
        //设置默认返回值
        boolean result = false;

        String no = userIntroductionVO.getNo();

        byte[] introduction = userIntroductionVO.getIntroduction();

        //设置存储介绍的txt文件位置
        String introductionPath = "var/www/data/introduction/"+no+".txt";

        //更新或者创建该文件
        File introductionPathFile = new File(introductionPath);

        //如果已经存在txt就删除它
        if (introductionPathFile .exists())
            introductionPathFile .delete();

        //创建新的文件
        try {
            introductionPathFile .createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }

        //创建并且初始化输出流
        OutputStream output = null;
        try {
            output = new FileOutputStream(introductionPathFile);
            //把byte形式的introduction写入file文件
            output.write(introduction);
            output.flush();
            //关闭读操作
            output.close();
            result = true;
        }catch (IOException e1){
            //一旦出现异常就把返回值设为错误
            result = false;
            e1.printStackTrace();
        }

        //输出返回值
        return result;
    }
}
