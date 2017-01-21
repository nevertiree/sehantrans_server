package cn.nevertiree.business.user.userRegister;

import cn.nevertiree.common.GenerateResponse;
import cn.nevertiree.common.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/email",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String registerByEmail(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password){

        String no = IdGenerator.getHashId(email);

        // 判断是否成功注册
        boolean initialLoginByEmail= registerService.initialLoginByEmail(no,email,password);
        boolean initialBaseByEmail = registerService.initialBaseByEmail(no,email);
        return (initialLoginByEmail&&initialBaseByEmail)?GenerateResponse.generateResponse(true,"100"):GenerateResponse.generateResponse(false,"200");
    }
}
