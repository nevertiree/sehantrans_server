package cn.nevertiree.business.user.userSetting.setInfo;

import cn.nevertiree.business.user.userSetting.SettingPersonServiceIntf;
import cn.nevertiree.business.user.userSetting.SettingServiceIntf;
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

/**修改用户的昵称 密码 性别 生日 手机 邮箱 地址 相片 简介*/

@Scope("prototype")
@Controller
@RequestMapping("/setting")
public class SettingGetController {

    @Autowired
    SettingServiceIntf settingServiceIntf;
    @Autowired
    SettingPersonServiceIntf settingPersonServiceIntf;

    /**1.通过UserNameVO修改用户的昵称(name)*/
    @RequestMapping(value = "setname",method = RequestMethod.GET)
    @ResponseBody
    public String setName(UserNameVO userNameVO){
        //解析no和name
        String no   = userNameVO.getNo();
        String name = userNameVO.getName();

        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**2.通过UserPwdVO修改用户的密码(pwd)*/
    @RequestMapping(value = "setpwd",method = RequestMethod.GET)
    @ResponseBody
    public String setPwd(UserPwdVO userPwdVO){
        //解析no和pwd
        String no   = userPwdVO.getNo();
        String pwd  = userPwdVO.getPwd();

        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**3.通过UserGenderVO查看和修改用户的性别(gender)*/
    @RequestMapping(value = "setgender",method = RequestMethod.GET)
    @ResponseBody
    public String setGender(UserGenderVO userGenderVO){
        //解析no和gender
        String no     = userGenderVO.getNo();
        String gender = userGenderVO.getGender();
        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**4.通过UserBirthVO查看和修改用户的生日(birth)*/
    @RequestMapping(value = "setbirth",method = RequestMethod.GET)
    @ResponseBody
    public String setBirth(UserBirthVO userBirthVO){
        //解析no和birthday
        String    no    = userBirthVO.getNo();
        Timestamp birth = userBirthVO.getBirth();
        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**5.通过UserMobileVO查看和修改用户的手机号(mobile)*/
    @RequestMapping(value = "setmobile",method = RequestMethod.GET)
    @ResponseBody
    public String setMobile(UserMobileVO userMobileVO){
        //解析no和mobile
        String  no     = userMobileVO.getNo();
        int     mobile = userMobileVO.getMobile();
        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**6.通过UserEmailVO查看和修改用户的邮箱(email)*/
    @RequestMapping(value = "setmobile",method = RequestMethod.GET)
    @ResponseBody
    public String setEmail(UserEmailVO userEmailVO){
        //解析no和email
        String  no    = userEmailVO.getNo();
        String  email = userEmailVO.getEmail();
        // TODO: 8/8/16 调用Service
        Map<String ,Object> response = new HashMap<String, Object>();

        return JsonUtil.toJson(response);
    }

    /**7.通过UserSiteVO修改用户的地址(site)*/
    @RequestMapping(value = "/setsite",method = RequestMethod.GET)
    @ResponseBody
    public String setSite(UserSiteVO userSiteVO){

        Map<String,Object> response = new HashMap<String,Object>();

        //TODO 更新的时候可以直接使用原生的updateByPrimaryKey方法
        if (settingServiceIntf.updateSiteInfo(userSiteVO)){
            response.put("success",true);
            response.put("msg",200);
        }else {
            response.put("success",false);
            response.put("msg","???");
        }
        return JsonUtil.toJson(response);
    }

    /**8.通过UserPortraitVO修改用户的头像(Portrait)*/
    @RequestMapping(value = "setportrait" ,method = RequestMethod.GET)
    @ResponseBody
    public String setPortrait(UserPortraitVO userPortraitVO){

        String no          = userPortraitVO.getNo();
        File   portaitFile = userPortraitVO.getPortrait();

        //准备用于返回JSON信息的Map
        Map<String,Object> response = new HashMap<String,Object>();

        //把客户端传递的byte[]输送到接口
        boolean result = settingPersonServiceIntf.updateUserPortait(no,portaitFile);

        //如果接口返回失败，说明存储失败
        if (!result){
            response.put("success",false);
            response.put("msg",000);
        }else {
            response.put("success",true);
            response.put("msg",001);
        }
        return JsonUtil.toJson(response);
    }

    /**9.通过UserIntroductionVO修改用户的个人简介(introduction)*/
    @RequestMapping(value = "setintroduction" ,method = RequestMethod.POST)
    @ResponseBody
    public String setIntroduction(UserIntroductionVO userIntroductionVO){

        String no           = userIntroductionVO.getNo();
        byte[] introduction = userIntroductionVO.getIntroduction();

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
        return JsonUtil.toJson(response);
    }
}
