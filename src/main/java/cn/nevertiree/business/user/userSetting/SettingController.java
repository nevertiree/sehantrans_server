package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.business.user.userLogin.LoginService;
import cn.nevertiree.common.GenerateResponse;
import cn.nevertiree.common.RegexUtil;
import cn.nevertiree.domain.Userbase;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lance Wang on 2017/1/10.
 */

@Scope("prototype")
@Controller
@RequestMapping("/user/setting")
public class SettingController {

    @Autowired
    private SettingService settingService;
    @Autowired
    private LoginService loginService;

    //获取信息
    @RequestMapping(value = "detail",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getDetail(@RequestParam(value = "no") String no){
        Userbase userbase = settingService.getDetail(no);
        if (userbase!=null){
            return GenerateResponse.generateResponse(true,"100",userbase);
        }else
            return GenerateResponse.generateResponse(false,"200");
    }

    // 修改密码
    @RequestMapping(value = "password",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String settingPassword(@RequestParam(value = "no") String no,@RequestParam(value = "password") String password){
        //update userlogin set password = #{1} where no = #{0}
        boolean successModify = settingService.modifyPassword(no,password);

        if (!RegexUtil.checkPassword(password))
            return GenerateResponse.generateResponse(false,"300");

        // TODO: 17-1-21
        // 1. 要先输入原始密码，确认无误后才能更新
        // 2. 修正无论如何都可以返回正确值的问题

        return (successModify)?GenerateResponse.generateResponse(true,"100"):GenerateResponse.generateResponse(false,"200");
    }

    // 修改名字
    @RequestMapping(value = "name",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String settingName(@RequestParam(value = "no") String no,@RequestParam(value = "name") String name){
        boolean isSuccess = settingService.modifyName(no,name);
        return (isSuccess)?GenerateResponse.generateResponse(true,"100"):GenerateResponse.generateResponse(false,"200");
    }

    // 修改性别
    @RequestMapping(value = "gender",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    // TODO: 17-1-21 添加正则表达式验证
    public String settingGender(@RequestParam(value = "no") String no,@RequestParam(value = "gender") String gender){
        boolean isSuccess = settingService.modifyGender(no,gender);
        return (isSuccess)?GenerateResponse.generateResponse(true,"100"):GenerateResponse.generateResponse(false,"200");    }

    // 修改生日
    @RequestMapping(value = "birth",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String settingBirth(@RequestParam(value = "no") String no,@RequestParam(value = "birth") String birthString){
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birth = sdf.parse(birthString);
            boolean isSuccess = settingService.modifyBirth(no,birth);
            return (isSuccess)?GenerateResponse.generateResponse(true,"100"):GenerateResponse.generateResponse(false,"200");
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return GenerateResponse.generateResponse(false,"300");
        }
    }

    // 修改手机号
    @RequestMapping(value = "mobile",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String settingTMobile(@RequestParam(value = "no") String no,@RequestParam(value="mobile") String mobile){
        if(!RegexUtil.checkMobile(mobile))
            return GenerateResponse.generateResponse(false,"300");
        boolean isSuccess = settingService.modifyMobile(no, mobile);
        return (isSuccess)?GenerateResponse.generateResponse(true,"100"):GenerateResponse.generateResponse(false,"200");
    }


    // 修改Email
    @RequestMapping(value = "email",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String settingEmail(@RequestParam(value = "no") String no,@RequestParam(value="email") String email){
        if (!RegexUtil.checkEmail(email))
            return GenerateResponse.generateResponse(false,"300");
        // TODO: 17-1-21 增加事物
        boolean isSuccess = settingService.modfifyEmail(no,email);
        return (isSuccess)?GenerateResponse.generateResponse(true,"100"):GenerateResponse.generateResponse(false,"200");
    }

}
