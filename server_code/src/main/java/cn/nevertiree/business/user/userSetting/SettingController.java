package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.common.JsonUtil;
import cn.nevertiree.domain.Userbaseinfo;
import cn.nevertiree.domain.Usersite;
import com.google.gson.Gson;
import com.sun.imageio.plugins.common.ImageUtil;
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

    //用于处理用户头像和个人介绍等等存储在文件系统的类
    @Autowired
    SettingPersonServiceIntf settingPersonServiceIntf;

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

        //准备用于返回JSON信息的Map
        Map<String,Object> response = new HashMap<String,Object>();

        //取得从文件系统读取的该用户照片byte流
        File portait = settingPersonServiceIntf.getUserPortait(no);

        //如果byte数组长度为0，说明读取失败
        if (portait==null){
            response.put("success",false);
            response.put("msg",000);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("portait",portait);
        }

        //放回一串JSON信息
        return JsonUtil.toJson(response);
    }

    //更新用户的头像--传入用户的no和用户相片的File文件，把File写入文件系统，并且在数据库记录位置
    @RequestMapping(value = "updateUserPortait" ,method = RequestMethod.GET)
    @ResponseBody
    public String updateUserPortait(String no,File portaitFile){
        //准备用于返回JSON信息的Map
        Map<String,Object> response = new HashMap<String,Object>();

        //把客户端传递的byte[]输送到接口
        boolean result = settingPersonServiceIntf.updateUserPortait(no,portaitFile);

        //如果接口返回失败，说明存储失败
        if (!result){
            response.put("success",false);
            response.put("msg",000);
        }else
        {
            response.put("success",true);
            response.put("msg",001);
        }

        //放回一串JSON信息
        return JsonUtil.toJson(response);

    }

    //获取用户的个人简介
    @RequestMapping(value = "getUserIntroduction" ,method = RequestMethod.POST)
    @ResponseBody
    public String getUserIntroduction(String no){

        //准备用于返回JSON信息的Map
        Map<String,Object> response = new HashMap<String,Object>();

        //取得从文件系统读取的该用户照片byte流
        byte[] introduction = settingPersonServiceIntf.getUserIntroduction(no);

        //如果byte数组长度为0，说明读取失败
        if (introduction.length==0){
            response.put("success",false);
            response.put("msg",000);
        }else
        {
            response.put("success",true);
            response.put("msg",001);
            response.put("introduction",introduction);
        }

        //放回一串JSON信息
        return JsonUtil.toJson(response);
    }

    //更新用户的个人简介--传入用户的no和用户简介，把个人简介写入文件系统，并且在数据库记录位置
    @RequestMapping(value = "updateUserIntroduction" ,method = RequestMethod.POST)
    @ResponseBody
    public String updateUserIntroduction(String no,byte[] introduction){

        //准备用于返回JSON信息的Map
        Map<String,Object> response = new HashMap<String,Object>();

        //把客户端传递的byte[]输送到接口
        boolean result = settingPersonServiceIntf.updateUserIntroduction(no,introduction);

        //如果接口返回失败，说明存储失败
        if (!result){
            response.put("success",false);
            response.put("msg","asdf");
        }else {
            response.put("success",true);
            response.put("msg",001);
        }

        //放回一串JSON信息
        return JsonUtil.toJson(response);
    }

}
