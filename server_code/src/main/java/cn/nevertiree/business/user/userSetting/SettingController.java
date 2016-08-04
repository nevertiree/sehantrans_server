package cn.nevertiree.business.user.userSetting;

import cn.nevertiree.domain.Userbaseinfo;
import cn.nevertiree.domain.Usersite;
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

    //根据no获取用户的地址信息
    @RequestMapping(value = "/getsite" ,method = RequestMethod.GET)
    public String getSiteInfo(String no){

        //使用Map输出结果
        Map<String,Object> response = new HashMap<>();

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

        Map<String,Object> response = new HashMap<>();

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
        Map<String,Object> response = new HashMap<>();

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
        Map<String,Object> response = new HashMap<>();

        //TODO 更新的时候可以直接使用原生的updateByPrimaryKey方法
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
}
