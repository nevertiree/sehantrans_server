package cn.nevertiree.business.user.userSetting.getInfo;

import cn.nevertiree.business.dao.UserpersoninfoMapper;
import cn.nevertiree.business.dao.UsersecurityMapper;
import cn.nevertiree.business.dao.UsersiteMapper;
import cn.nevertiree.business.user.userSetting.dvo.UserSiteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Lance on 8/9/16.
 */

@Service
public class SettingGetService implements SettingGetServiceIntf {

    @Autowired
    UserpersoninfoMapper userpersoninfoMapper;

    @Autowired
    UsersecurityMapper usersecurityMapper;

    @Autowired
    UsersiteMapper usersiteMapper;

    public String getName(String no){
        return userpersoninfoMapper.getName(no);
    }

    public String getPwd(String no){
        return usersecurityMapper.getPwd(no);
    }
    public String getGender(String no){
        return userpersoninfoMapper.getGender(no);
    }

    public Timestamp getBirth(String no){
        return userpersoninfoMapper.getBirth(no);
    }

    public int getMobile(String no){
        return userpersoninfoMapper.getMobile(no);
    }

    public String getEmail(String no){
        return userpersoninfoMapper.getEmail(no);
    }

    public UserSiteVO getSite(String no){
        return usersiteMapper.getSite(no);
    }
    public File getPortrait(String no){
        //创建返回的byte数组，并初始化为null，如果后续步骤失败，直接返回null
        File portait = null;

        //根据用户no查询该用户存储头像的地址
        String picturePath = userpersoninfoMapper.getPicturePath(no);

        //根据地址创建图片的File对象
        File pictureFile = new File(picturePath);

        //创建输入流，从文件系统中读取图片，并且转换成byte[]
        /*try {
            FileInputStream input = new FileInputStream(pictureFile);
            portait = new byte[(int)pictureFile.length()];
            input.read(portait);
            input.close();
        }catch (IOException e1){
            //出现异常时把portait重新设成null
            portait = null;
            e1.printStackTrace();
        }*/

        //输出byte字节流
        return portait;    }
    public byte[] getIntroduction(String no){
        //创建返回的byte数组，并初始化为null，如果后续步骤失败，直接返回null
        byte[] introduction = null;

        //从数据库中找出存储个人介绍的txt地址
        String introductionPath = userpersoninfoMapper.getIntroductionPath(no);

        //创建File读取该文件
        File introductionFile = new File(introductionPath);

        //从文件系统中读取个人简介，并且转换成byte[]
        try{
            //创建输入流
            FileInputStream input = new FileInputStream(introductionFile);
            //初始化introduction的byte数组
            introduction = new byte[(int)introductionFile.length()];
            //把File中的内容写入introduction
            input.read(introduction);
            //关闭流
            input.close();
        }catch (IOException e){
            //出现异常时把introduction重新设成null
            introduction= null;
            e.printStackTrace();
        }

        //返回个人简介的byte[]
        return introduction;

    }
}
