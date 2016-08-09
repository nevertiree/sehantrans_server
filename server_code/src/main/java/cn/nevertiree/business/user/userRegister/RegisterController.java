package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.business.user.userRegister.dvo.RegisterVO;
import cn.nevertiree.common.IdGenerator;
import cn.nevertiree.common.JsonUtil;
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
 * Created by Lance on 7/25/16.
 */

@Scope("prototype")
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    RegisterServiceIntf registerServiceIntf;

    /*TODO 1 邮箱
        正则表达式检验字符串是否符合邮箱规范
        检查该邮箱是否已经注册过，如果没有就发送激活邮件，否则报错
      TODO 2 密码
        密码长度至少六位而且必须而且只能含英文与数字
      TODO 3.服务器完成注册
        在userSecurity和userBase中insert邮箱密码ID和默认用户名    **/

    //根据LoginName判断是否重名(这里的name是广义的)
    @RequestMapping(value = "/create" ,method = RequestMethod.GET)
    @ResponseBody
    public String createUser(RegisterVO registerVO){

        //开始建立用户的信息row（在3张表中同时建立）并且得到返回信息
        String result = registerServiceIntf.createUser(registerVO);
        Map<String,Object> response = new HashMap<String,Object>();

        //只有等于001时才成功
        if (result.equals(Integer.toString(001))){
            response.put("success",true);
            response.put("msg",001);
        }else{
            response.put("success",false);
            response.put("msg" , result);
        }

        return JsonUtil.toJson(response);
    }
}
