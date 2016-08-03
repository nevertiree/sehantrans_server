package cn.nevertiree.business.user.userSetting;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //根据用户No取得该用户的地址信息
    @RequestMapping(value = "/getsite",method = RequestMethod.GET)
    @ResponseBody
    public String getUserSite(UserSiteVO siteVO){
        //取得用户ID
        String id= siteVO.getNo();

        //准备返回值
        Gson gson= new Gson();
        Map<String,Object> response=new HashMap<>();

        //如果数据库返回值为空 返回false
        if (!settingServiceIntf.checkByNo(id)){
            response.put("success",false);
            response.put("msg","username is not found");
            //把返回值变成JSON字符串
            System.out.println(gson.toJson(response)+id+settingServiceIntf.checkByNo(id));
            return gson.toJson(response)+id+settingServiceIntf.checkByNo(id);

        }

        //在Map中插入返回的UserSiteVO
        response.put("success",true);
        response.put("siteInfo",settingServiceIntf.getUserSite(id));
        //把返回值变成JSON字符串
        System.out.println(gson.toJson(response)+id+settingServiceIntf.checkByNo(id));
        return gson.toJson(response)+id+settingServiceIntf.checkByNo(id);

    }

}
