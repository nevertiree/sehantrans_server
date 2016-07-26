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
    * 我的想法
    * todo 1.运用类似AJAX的方法
    * 先测试用户名是否重复(与服务器合作) return "success:true or false"
    * 再测试用户的密码是否过于简单(客户端本地用正则测试)
    * 两个测试都成功的情况下再发送注册信息
    * todo 2.向服务器发送信息
    *
    * todo 3.服务器返回反馈--》完成注册
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
