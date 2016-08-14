package cn.nevertiree.business.user.userSetting.getInfo;

import cn.nevertiree.business.user.userSetting.dvo.*;
import cn.nevertiree.common.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**获取用户的昵称 密码 性别 生日 手机 邮箱 地址 相片 简介*/

@Scope("prototype")
@Controller
@RequestMapping("/getsetting")
public class SettingGetController {

    @Autowired
    SettingGetServiceIntf settingGetServiceIntf;

    //返回map
    private static Map<String ,Object> response = new HashMap<String, Object>();

    /**1.通过UserNameVO查看用户的昵称(name)*/
    @RequestMapping(value = "getname" ,method = RequestMethod.GET)
    @ResponseBody
    public String getName(UserNameVO userNameVO){

        //获取名字
        String name = settingGetServiceIntf.getName(userNameVO.getNo());
        //如果没有名字返回
        response.clear();
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
        response.clear();
        //获取密码
        String pwd = settingGetServiceIntf.getPwd(userPwdVO.getNo());
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
        response.clear();
        //获取性别
        String gender = settingGetServiceIntf.getGender(userGenderVO.getNo());
        if (gender==null){
            response.put("success",false);
            response.put("msg",002);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("gender",gender);
        }
        return JsonUtil.toJson(response);
    }

    /**4.通过UserBirthVO查看用户的生日(birth)*/
    @RequestMapping(value = "getbirth" ,method = RequestMethod.GET)
    @ResponseBody
    public String getBirth(UserBirthVO userBirthVO){
        response.clear();
        //获取生日
        Timestamp birth= settingGetServiceIntf.getBirth(userBirthVO.getNo());
        if (birth==null){
            response.put("success",false);
            response.put("msg",002);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("birth",birth);
        }
        return JsonUtil.toJson(response);
    }

    /**5.通过UserMobileVO查看用户的手机号(mobile)*/
    @RequestMapping(value = "getmobile" ,method = RequestMethod.GET)
    @ResponseBody
    public String getMobile(UserMobileVO userMobileVO){
        response.clear();
        //获取手机号
        int mobile= settingGetServiceIntf.getMobile(userMobileVO.getNo());
        if (mobile==0){
            response.put("success",false);
            response.put("msg",002);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("mobile",mobile);
        }
        return JsonUtil.toJson(response);
    }

    /**6.通过UserEmailVO查看用户的邮箱(email)*/
    @RequestMapping(value = "getemail" ,method = RequestMethod.GET)
    @ResponseBody
    public String getEmail(UserEmailVO userEmailVO){
        response.clear();
        //获取邮箱
        String email= settingGetServiceIntf.getEmail(userEmailVO.getNo());
        if (email==null){
            response.put("success",false);
            response.put("msg",002);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("email",email);
        }
        return JsonUtil.toJson(response);
    }

    /**7.通过UserSiteVO查看用户的地址(site)*/
    @RequestMapping(value = "/getsite" ,method = RequestMethod.GET)
    @ResponseBody
    public String getSite(UserSiteVO userSiteVO){
        response.clear();
        //获取地址
        UserSiteVO site= settingGetServiceIntf.getSite(userSiteVO.getNo());
        if (site==null){
            response.put("success",false);
            response.put("msg",002);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("site",site);
        }
        return JsonUtil.toJson(response);
    }

    /**8.通过UserPortraitVO查看用户的头像(Portrait)*/
    @RequestMapping(value = "getportrait" ,method = RequestMethod.GET)
    @ResponseBody
    public String getPortrait(UserPortraitVO userPortraitVO){
        response.clear();
        //获取头像
        File portrait= settingGetServiceIntf.getPortrait(userPortraitVO.getNo());
        if (portrait==null){
            response.put("success",false);
            response.put("msg",002);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("portrait",portrait);
        }
        return JsonUtil.toJson(response);
    }

    /**9.通过UserIntroductionVO查看用户的个人简介(introduction)*/
    @RequestMapping(value = "getintroduction" ,method = RequestMethod.POST)
    @ResponseBody
    public String getIntroduction(UserIntroductionVO userIntroductionVO){
        response.clear();
        //获取个人介绍
        byte[] introduction= settingGetServiceIntf.getIntroduction(userIntroductionVO.getNo());
        if (introduction==null){
            response.put("success",false);
            response.put("msg",002);
        }else {
            response.put("success",true);
            response.put("msg",001);
            response.put("introduction",introduction);
        }
        return JsonUtil.toJson(response);
    }

}