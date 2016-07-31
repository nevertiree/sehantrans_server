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
@RequestMapping(value = "/setting")
public class SettingController {

    @Autowired
    SettingServiceIntf settingServiceIntf;

    //设置用户的地址信息
    @RequestMapping(value = "/setSite",method = RequestMethod.GET)
    @ResponseBody
    public void setUserSite(UserSiteVO site){
        String userNo=site.getNo();
        String province =site.getProvince();
        String city=site.getCity();
        String county=site.getCounty();
        String district=site.getDistrict();
        String street=site.getStreet();

    }

    //根据用户No取得该用户的地址信息
    @RequestMapping(value = "/getSite",method = RequestMethod.GET)
    @ResponseBody
    public String getUserSite(UserSiteVO userSiteVO){
        //取得用户ID
        String userNo= userSiteVO.getNo();

        //准备返回值
        Map response = new HashMap();
        Gson gson= new Gson();

        //如果数据库返回值为空 返回false
        if (settingServiceIntf.getUserSite(userNo)==null){
            response.put("success",false);
            response.put("msg","username is not found");
        }else{//在Map中插入返回的UserSiteVO
            response.put("success",true);
            response.put("siteInfo",settingServiceIntf.getUserSite(userNo));
        }

        //返回JSON字符串
        return gson.toJson(response);
    }

}
