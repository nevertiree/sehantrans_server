package cn.nevertiree.business.user.userSetting.setInfo;

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

/**修改用户的昵称 密码 性别 生日 手机 邮箱 地址 相片 简介*/

@Scope("prototype")
@Controller
@RequestMapping("/setsetting")
public class SettingSetController {

    @Autowired
    SettingSetServiceIntf settingSetServiceIntf;

    private String resultMap(boolean result){
        Map<String ,Object> response = new HashMap<String, Object>();
        if (result) response.put("success",true);
        else response.put("success",false);

        return JsonUtil.toJson(response);
    }

    /**1.通过UserNameVO修改用户的昵称(name)*/
    @RequestMapping(value = "setname",method = RequestMethod.GET)
    @ResponseBody
    public String setName(UserNameVO userNameVO){

        boolean result = settingSetServiceIntf.setName(userNameVO);
        return resultMap(result);
    }

    /**2.通过UserPwdVO修改用户的密码(pwd)*/
    @RequestMapping(value = "setpwd",method = RequestMethod.GET)
    @ResponseBody
    public String setPwd(UserPwdVO userPwdVO){

        boolean result = settingSetServiceIntf.setPwd(userPwdVO);

        return resultMap(result);
    }

    /**3.通过UserGenderVO查看和修改用户的性别(gender)*/
    @RequestMapping(value = "setgender",method = RequestMethod.GET)
    @ResponseBody
    public String setGender(UserGenderVO userGenderVO){

        boolean result = settingSetServiceIntf.setGender(userGenderVO);

        return resultMap(result);

    }

    /**4.通过UserBirthVO查看和修改用户的生日(birth)*/
    @RequestMapping(value = "setbirth",method = RequestMethod.GET)
    @ResponseBody
    public String setBirth(UserBirthVO userBirthVO){

        boolean result = settingSetServiceIntf.setBirth(userBirthVO);

        return resultMap(result);

    }

    /**5.通过UserMobileVO查看和修改用户的手机号(mobile)*/
    @RequestMapping(value = "setmobile",method = RequestMethod.GET)
    @ResponseBody
    public String setMobile(UserMobileVO userMobileVO){

        boolean result = settingSetServiceIntf.setMobile(userMobileVO);

        return resultMap(result);

    }

    /**6.通过UserEmailVO查看和修改用户的邮箱(email)*/
    @RequestMapping(value = "setmobile",method = RequestMethod.GET)
    @ResponseBody
    public String setEmail(UserEmailVO userEmailVO){

        boolean result = settingSetServiceIntf.setEmail(userEmailVO);

        return resultMap(result);

    }

    /**7.通过UserSiteVO修改用户的地址(site)*/
    @RequestMapping(value = "/setsite",method = RequestMethod.GET)
    @ResponseBody
    public String setSite(UserSiteVO userSiteVO){

        boolean result = settingSetServiceIntf.setSite(userSiteVO);

        return resultMap(result);

    }

    /**8.通过UserPortraitVO修改用户的头像(Portrait)*/
    @RequestMapping(value = "setportrait" ,method = RequestMethod.GET)
    @ResponseBody
    public String setPortrait(UserPortraitVO userPortraitVO){

        boolean result = settingSetServiceIntf.setPortrait(userPortraitVO);

        return resultMap(result);

    }

    /**9.通过UserIntroductionVO修改用户的个人简介(introduction)*/
    @RequestMapping(value = "setintroduction" ,method = RequestMethod.POST)
    @ResponseBody
    public String setIntroduction(UserIntroductionVO userIntroductionVO){

        boolean result = settingSetServiceIntf.setIntroduction(userIntroductionVO);

        return resultMap(result);
    }
}
