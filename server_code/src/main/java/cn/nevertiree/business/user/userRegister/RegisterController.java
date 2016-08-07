package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.common.IdGenerator;
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

    /*
    TODO 1 邮箱

        正则表达式检验字符串是否符合邮箱规范

        检查该邮箱是否已经注册过，如果没有就发送激活邮件，否则报错

    TODO 2 密码

        密码长度至少六位而且必须而且只能含英文与数字

    TODO 3.服务器完成注册

        在userSecurity和userBase中insert邮箱密码ID和默认用户名

    * */

    //根据用户名注册的时候判断是否重名(这里的name是广义的)
    @RequestMapping(value = "/create" ,method = RequestMethod.GET)
    @ResponseBody
    public String createUser(RegisterVO registerVO){
        //得到用户想要注册的用户名和M密码
        String name = registerVO.getName();
        String pwd  = registerVO.getPwd();

        Map<String,Object> response = new HashMap<String,Object>();
        Gson gson= new Gson();

        // TODO: 8/4/16
        // 200表示成功
        // 201表示注册方式重复 name是广义的 包括用于注册的邮箱电话等等
        // 202表示数据库插入失败

        if (registerServiceIntf.checkName(name)){
            response.put("success",true);
        }else
        {
            response.put("success",false);
            response.put("msg",201);
            return gson.toJson(response);
        }

        //得到唯一的userNo
        String no = IdGenerator.getHashId(name);

        //开始建立用户的信息row（在3张表中同时建立）
        if (registerServiceIntf.createUser(no,name,pwd)){
            response.put("success",true);
            response.put("msg",200);
        }else{
            response.put("success",false);
            response.put("msg" , 202);
        }

        return gson.toJson(response);
    }

}
