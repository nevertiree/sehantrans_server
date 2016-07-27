package cn.nevertiree.business.user.userRegister;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    /*
    TODO 1 邮箱

        正则表达式检验字符串是否符合邮箱规范

        检查该邮箱是否已经注册过，如果没有就发送激活邮件，否则报错

    TODO 2 密码

        密码长度至少六位而且必须而且只能含英文与数字

    TODO 3.服务器完成注册

        在userSecurity和userBase中insert邮箱密码ID和默认用户名

    * */

    //根据用户名注册的时候判断是否重名
    @RequestMapping(value = "/checkName" ,method = RequestMethod.GET)
    @ResponseBody
    public String checkName(RegisterNameParamVO registerNameParamVO){
        //得到用户想要注册的用户名
        String name = registerNameParamVO.getName();

        Map<String,Object> response = new HashMap<>();

        if (registerServiceIntf.checkName(name)==true){
            response.put("success",true);
        }else
            response.put("success",false);

        Gson gson= new Gson();
        return gson.toJson(response);
    }

}
