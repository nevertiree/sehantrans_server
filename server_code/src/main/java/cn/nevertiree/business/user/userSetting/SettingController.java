package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.business.user.userSetting.dvo.UserSettingType;
import cn.nevertiree.common.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lance on 8/14/16.
 */

@Scope("prototype")
@Controller
@RequestMapping(value = "/setting")

public class SettingController {

    @Autowired
    SettingServiceIntf settingServiceIntf;

    /** 获取信息*/
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public String getInfo(UserSettingType userSettingType) throws Exception{

        UserSettingType returnValue = settingServiceIntf.getInfo(userSettingType);

        //根据数据库返回的returnValue决定成功标示符、返回给客户端的returnMessage以及returnValue本身
        boolean result = (returnValue!=null);
        String returnMessage = (result)?"001":"002";
        return returnGetResult(result,returnMessage,returnValue);
    }

    private static String returnGetResult(boolean result,String msg,Object value){
        Map<String,Object> response = new HashMap<String, Object>();
        if (result){
            response.put("success",true);
            response.put("result",value);
            response.put("msg",msg);
        }else {
            response.put("success",false);
            response.put("msg",msg);
        }
        return JsonUtil.toJson(response);
    }

    /** 修改信息*/
    @RequestMapping(value = "/set",method = RequestMethod.GET)
    @ResponseBody
    public String setInfo(UserSettingType userSettingType) throws Exception{

        //根据数据库返回的result决定成功标示符、返回给客户端的returnMessage
        boolean result = settingServiceIntf.setInfo(userSettingType);
        String returnMassage = (result)?"001":"002";
        return returnSetResult(result,returnMassage);
    }

    private static String returnSetResult(boolean result,String msg){
        Map<String,Object> response = new HashMap<String, Object>();
        if (result){
            response.put("success",true);
            response.put("msg",msg);
        }else {
            response.put("success",false);
            response.put("msg",msg);
        }
        return JsonUtil.toJson(response);
    }

}
