package cn.nevertiree.business.user.userSetting.getInfo;

import cn.nevertiree.business.user.userSetting.dvo.*;
import cn.nevertiree.common.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**获取用户的昵称 密码 性别 生日 手机 邮箱 地址 相片 简介*/

@Scope("prototype")
@Controller
@RequestMapping("/getsetting")
public class SettingGetController {

    @Autowired
    SettingGetServiceIntf settingGetServiceIntf;

    /**1.通过UserNameVO查看用户的昵称(name)*/
    @RequestMapping(value = "getname" ,method = RequestMethod.GET)
    @ResponseBody
    public String getName(UserNameVO userNameVO){

        Map<String ,Object> response = new HashMap<String, Object>();
        //获取名字
        String name = settingGetServiceIntf.getName(userNameVO.getNo());
        if (name==null){
            response.put("success",false);
            response.put("msg",002);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("name",name);
        }
        return JsonUtil.toJson(response);
    }

    /**2.通过UserPwdVO查看用户的密码(pwd)*/
    @RequestMapping(value = "getpwd" ,method = RequestMethod.GET)
    @ResponseBody
    public String getPwd(UserPwdVO userPwdVO){
        Map<String ,Object> response = new HashMap<String, Object>();
        //获取名字
        String pwd = settingGetServiceIntf.getName(userPwdVO.getNo());
        if (pwd==null){
            response.put("success",false);
            response.put("msg",002);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("pwd",pwd);
        }
        return JsonUtil.toJson(response);
    }

    /**3.通过UserGenderVO查看用户的性别(gender)*/
    @RequestMapping(value = "getgender" ,method = RequestMethod.GET)
    @ResponseBody
    public String getGender(UserGenderVO userGenderVO){
        //解析no
        String no = userGenderVO.getNo();

        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**4.通过UserBirthVO查看用户的生日(birth)*/
    @RequestMapping(value = "getbirth" ,method = RequestMethod.GET)
    @ResponseBody
    public String getBirth(UserBirthVO userBirthVO){
        //解析no
        String no = userBirthVO.getNo();

        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**5.通过UserMobileVO查看用户的手机号(mobile)*/
    @RequestMapping(value = "getmobile" ,method = RequestMethod.GET)
    @ResponseBody
    public String getMobile(UserMobileVO userMobileVO){
        //解析no
        String no = userMobileVO.getNo();

        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**6.通过UserEmailVO查看用户的邮箱(email)*/
    @RequestMapping(value = "getemail" ,method = RequestMethod.GET)
    @ResponseBody
    public String getEmail(UserEmailVO userEmailVO){
        //解析no
        String no = userEmailVO.getNo();

        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**7.通过UserSiteVO查看用户的地址(site)*/
    @RequestMapping(value = "/getsite" ,method = RequestMethod.GET)
    @ResponseBody
    public String getSite(UserSiteVO userSiteVO){
        //解析no
        String no = userSiteVO.getNo();

        //使用Map输出结果
        Map<String,Object> response = new HashMap<String,Object>();

        /*//根据数据库中的存在情况设置返回map
        if (settingServiceIntf.getSiteInfo(no)==null){
            response.put("success",false);
            response.put("msg","username is not found");
        }else {
            //在Map中插入返回的UserSiteVO
            response.put("success",true);
            response.put("value",settingServiceIntf.getSiteInfo(no));
        }*/

        //把结果转成JSON返回
        return JsonUtil.toJson(response);
    }

    /**8.通过UserPortraitVO查看用户的头像(Portrait)*/
    @RequestMapping(value = "getportrait" ,method = RequestMethod.GET)
    @ResponseBody
    public String getPortrait(UserPortraitVO userPortraitVO){

        String no = userPortraitVO.getNo();

        //准备用于返回JSON信息的Map
        Map<String,Object> response = new HashMap<String,Object>();

        //取得从文件系统读取的该用户照片byte流
        //File portait = settingPersonServiceIntf.getUserPortait(no);

        //如果byte数组长度为0，说明读取失败
        /*if (portait==null){
            response.put("success",false);
            response.put("msg",000);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("portait",portait);
        }*/

        return JsonUtil.toJson(response);
    }

    /**9.通过UserIntroductionVO查看用户的个人简介(introduction)*/
    @RequestMapping(value = "getintroduction" ,method = RequestMethod.POST)
    @ResponseBody
    public String getIntroduction(UserIntroductionVO userIntroductionVO){

        String no = userIntroductionVO.getNo();

        //准备用于返回JSON信息的Map
        Map<String,Object> response = new HashMap<String,Object>();

        //取得从文件系统读取的该用户照片byte流
        /*byte[] introduction = settingPersonServiceIntf.getUserIntroduction(no);

        //如果byte数组长度为0，说明读取失败
        if (introduction.length==0){
            response.put("success",false);
            response.put("msg",000);
        }else
        {
            response.put("success",true);
            response.put("msg",001);
            response.put("introduction",introduction);
        }*/

        //放回一串JSON信息
        return JsonUtil.toJson(response);
    }

}