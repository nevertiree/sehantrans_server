package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.common.GenerateResponse;
import cn.nevertiree.common.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lance Wang on 2017/1/10.
 */
@Scope("prototype")
@Controller
@RequestMapping("/user/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/email",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    @Transactional
    public String registerByEmail(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password){

        String no = IdGenerator.getHashId(email);

        // 在登录表里建立新行
        boolean initialLoginByEmail= registerService.initialLoginByEmail(no,email,password);
        // 在基本信息表里建立新行
        boolean initialBaseByEmail = registerService.initialBaseByEmail(no,email);
        // 判断是否成功注册
        return (initialLoginByEmail&&initialBaseByEmail)?GenerateResponse.generateResponse(true,"100"):GenerateResponse.generateResponse(false,"200");
    }
}
