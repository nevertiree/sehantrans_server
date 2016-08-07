package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.domain.Userbaseinfo;
import cn.nevertiree.domain.Usersite;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lance on 7/26/16.
 */

@Scope("prototype")
@Controller
@RequestMapping("/setting")
public class SettingController {

    @Autowired
    SettingServiceIntf settingServiceIntf;

    //根据no获取用户的地址信息
    @RequestMapping(value = "/getsite" ,method = RequestMethod.GET)
    public String getSiteInfo(String no){

        //使用Map输出结果
        Map<String,Object> response = new HashMap<String,Object>();

        //根据数据库中的存在情况设置返回map
        if (settingServiceIntf.getSiteInfo(no)==null){
            response.put("success",false);
            response.put("msg","username is not found");
        }else {
            //在Map中插入返回的UserSiteVO
            response.put("success",true);
            response.put("value",settingServiceIntf.getSiteInfo(no));
        }

        //把结果转成JSON返回
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    //更新用户的地址信息
    @RequestMapping(value = "/updatesite",method = RequestMethod.GET)
    @ResponseBody
    public String updateSite(Usersite siteVO){

        Map<String,Object> response = new HashMap<String,Object>();

        //TODO 更新的时候可以直接使用原生的updateByPrimaryKey方法
        if (settingServiceIntf.updateSiteInfo(siteVO)){
            response.put("success",true);
            response.put("msg",200);
        }else {
            response.put("success",false);
            response.put("msg","???");
        }

        //Map转成JSON返回
        Gson gson =new Gson();
        return gson.toJson(response);
    }

    // TODO BaseInfo基本信息部分
    // TODO -->no name gender birth mobile registerTime
    // TODO 需要和阙沟通实现

    //获取用户的基本信息 返回一个JSON的String
    @RequestMapping(value = "getbaseinfo" ,method = RequestMethod.GET)
    @ResponseBody
    public String getBaseInfo(String no){

        //准备用户返回的Map
        Map<String,Object> response = new HashMap<String,Object>();

        if (settingServiceIntf.getBaseInfo(no)!=null){
            response.put("success",true);
            response.put("msg",200);
            response.put("value",settingServiceIntf.getBaseInfo(no));
        } else {
            response.put("success",false);
            response.put("msg",404);
        }

        //Map转成JSON返回
        Gson gson =new Gson();
        return gson.toJson(response);
    }

    //设置用户的基本信息
    @RequestMapping(value = "updatebaseinfo" ,method = RequestMethod.GET)
    @ResponseBody
    public String updateBaseInfo(Userbaseinfo baseInfo){

        Map<String,Object> response = new HashMap<String,Object>();

        //TODO 更新的时候可以直接使用原生的updateByPrimaryKey方法
        
        //// TODO: 8/4/16 貌似u不可以这么简单粗暴--可以用MyBatis事务 
        if (settingServiceIntf.updateBaseInfo(baseInfo)){
            response.put("success",true);
            response.put("msg",200);
        }else {
            response.put("success",false);
            response.put("msg","???");
        }

        //Map转成JSON返回
        Gson gson =new Gson();
        return gson.toJson(response);
    }

    //获取用户的头像
    @RequestMapping(value = "getUserPortait" ,method = RequestMethod.GET)
    @ResponseBody
    public String getUserPortait(String no){
        return "";
    }

    //更新用户的头像
    @RequestMapping(value = "updateUserPortait" ,method = RequestMethod.GET)
    @ResponseBody
    public String updateUserPortait(String no,String bytes){
        //传入用户的no和用户相片的二进制文件，把二进制内容写入文件系统，并且在数据库记录位置
        return "";
    }

    //获取用户的个人简介
    @RequestMapping(value = "getUserIntroduction" ,method = RequestMethod.GET)
    @ResponseBody
    public String getUserIntroduction(String no){

        //设置同一的编码
        String encoding = "utf8";


        // TODO: 8/8/16 filePath应该从database中读

        //设置存储介绍的txt文件位置
        String filePath = "var/www/data/introduction/"+no+".txt";
        //更新或者创建该文件
        File file = new File(filePath);
        //如果已经存在txt就删除它
        if (file.exists())  file.delete();
        //创建新的文件
        try {
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }

        //创建并且初始化输入流
        InputStream input = null;
        try {
            input = new FileInputStream(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //开辟一个空间用于接受文件读进来的数据
        byte bytes[] = new byte[];

        return "";
    }

    //更新用户的个人简介--传入用户的no和用户简介，把个人简介写入文件系统，并且在数据库记录位置
    @RequestMapping(value = "updateUserIntroduction" ,method = RequestMethod.GET)
    @ResponseBody
    public String updateUserIntroduction(String no,String introduction){
        //设置存储介绍的txt文件位置
        String filePath = "var/www/data/introduction/"+no+".txt";
        //更新或者创建该文件
        File file = new File(filePath);
        //如果已经存在txt就删除它
        if (file.exists())  file.delete();
        //创建新的文件
        try {
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }

        //创建并且初始化输出流
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
        }catch (IOException e1){
            e1.printStackTrace();
        }

        //把个人介绍的字符串转化成byte[]
        byte bytes[] = introduction.getBytes();

        //把byte数组写入到文件之中
        try {
            out.write(bytes);
        }catch (IOException e2){
            e2.printStackTrace();
        }

        //关闭读操作
        try {
            out.close();
        }catch (IOException e3){
            e3.printStackTrace();
        }


        return "";
    }

}
