package cn.nevertiree.business.user.userLogin;

import cn.nevertiree.business.user.userLogin.dvo.LoginPwdVO;
import cn.nevertiree.common.GenerateResponse;
import cn.nevertiree.common.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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

        String loginName = pwdVO.getLoginName();
        String pwd  = pwdVO.getPwd();
        String token= pwdVO.getToken();

        //todo 返回值JSON如下
        //success:ture/false
        //token:token(if and only if success is true)
        //msg: 000(success)
        //     100(username isn't existed)
        //     200(username is existed but password or username is wrong)
        //     300(username and password are right but login in strange device)

        // TODO: 验证用户名-token和用户名-密码

        //1.调用checkName函数验证 返回boolean 如果错误说明用户名不存在
        boolean hasName = loginServiceIntf.hasLoginName(loginName);
        if (!hasName)
            return GenerateResponse.generateResponse(false,"100");

        //2.调用checkPwd函数验证 返回boolean 如果错误说明密码错误或者用户名输入错误
            //select count(*) from userSecurity where name = "name" and pwd = "pwd";

        boolean isRightPwd = loginServiceIntf.isRightPwd(loginName,pwd);
        if (!isRightPwd)
            return GenerateResponse.generateResponse(false,"200");

        //3.调用checkToken函数验证 返回boolean 如果错误说明非本机登录

        //4.以上3方面同时成功时返回success 同时用UserTokenGenerator更新token并返回 undo

        return GenerateResponse.generateResponse(true,"000");
    }
}
