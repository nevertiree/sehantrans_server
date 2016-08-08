package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.business.dao.UserpersoninfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

/**
 * Created by Lance on 8/8/16.
 */
public class SettingPersonService implements SettingPersonServiceIntf {

    @Autowired
    UserpersoninfoMapper userpersoninfoMapper;

    //取得用户头像
    public File getUserPortait(String no){

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
        return portait;
    }

    //修改用户头像
    public boolean updateUserPortait(String no ,File portaitFile){

        boolean result = false;

        //TODO 设置存储图片的文件位置????不同格式？？？
        String picturePath = "var/www/data/portait/"+no+".txt";

        /*File pictureFile = new File();*/

        /*try {
            FileOutputStream output = new FileOutputStream(pictureFile);
            output.write(portait);
            output.flush();
            output.close();
        }catch (IOException e2){
            e2.printStackTrace();
        }*/

        return result;
    }

    //取得与修改用户自我介绍
    public byte[] getUserIntroduction(String no){

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

    public boolean updateUserIntroduction(String no,byte[] introduction){
        //设置默认返回值
        boolean result = false;

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
