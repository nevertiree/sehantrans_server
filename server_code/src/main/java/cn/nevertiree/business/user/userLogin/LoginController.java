package cn.nevertiree.business.user.userLogin;

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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginServiceIntf loginServiceIntf;

    //以password的手段登录（假设还有其他的手段）
    @RequestMapping(value = "/common",method = RequestMethod.GET)
    @ResponseBody
    public String loginByPwd(LoginPwdVO pwdVO){
        //解析VO用户名 密码 和TOKEN
        String name = pwdVO.getName();
        String pwd  = pwdVO.getPwd();
        String token= pwdVO.getToken();

        Gson gson=new Gson();
        //todo 返回值JSON如下
        //success:ture/false
        //token:token(if and only if success is true)
        //msg: 000(success)
        //     100(username isn't existed)
        //     200(username is existed but password or username is wrong)
        //     300(username and password are right but login in strange device)
        Map<String,Object> response=new HashMap<String,Object>();

        // TODO: 验证用户名-token和用户名-密码

        //1.调用checkName函数验证 返回boolean 如果错误说明用户名不存在
        if (!loginServiceIntf.checkName(name)){
            response.put("success",false);
            response.put("msg","该用户名不存在");//ERROR 100 (username isn't existed)
            return gson.toJson(response);
        }

        //2.调用checkPwd函数验证 返回boolean 如果错误说明密码错误或者用户名输入错误
            //select count(*) from userSecurity where name = "name" and pwd = "pwd";
        if (!loginServiceIntf.checkPwd(name,pwd)){
            response.put("success",false);
            response.put("msg","用户名或者密码输入错误");//ERROR 200(name is existed but pwd or name is wrong)
            return gson.toJson(response);
        }

        //3.调用checkToken函数验证 返回boolean 如果错误说明非本机登录

        /*if (!loginServiceIntf.checkToken(name,token)){
            response.put("success",false);
            response.put("msg","300");//ERROR 300(name and pwd are right but login in strange device)
            return gson.toJson(response);
        }*/

        //4.以上3方面同时成功时返回success 同时用UserTokenGenerator更新token并返回

        response.put("success",true);
        response.put("msg","登录成功");//ERROR
        return gson.toJson(response);

    }
}
