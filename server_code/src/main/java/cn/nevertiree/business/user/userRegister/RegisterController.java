package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.business.user.userRegister.dvo.RegisterVO;
import cn.nevertiree.common.GenerateResponse;
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

    //根据LoginName判断是否重名 通常指的是邮箱
    @RequestMapping(value = "/create" ,method = RequestMethod.GET)
    @ResponseBody
    public String createUser(RegisterVO registerVO){

        //先判断loginName是否重复
        String loginName = registerVO.getLoginName();
        boolean isDuplicateName = registerServiceIntf.hasLoginName(loginName);

        if(isDuplicateName)
            return GenerateResponse.generateResponse(false,"100");

        //如果该名没有重复使用 根据用户的注册码得到唯一的userNo && token
        registerVO.setNo(IdGenerator.getHashId(loginName));
        registerVO.setToken(IdGenerator.getHashId());
        registerVO.setIp("127.0.0.1");

        //开始建立用户的信息row（在3张表中同时建立）并且得到返回信息
        String result = registerServiceIntf.createUser(registerVO);

        //只有等于001时才成功
        if (result.equals(Integer.toString(001))){
            return GenerateResponse.generateResponse(true,"001");
        }else {
            return GenerateResponse.generateResponse(false,result);
        }
    }
}
