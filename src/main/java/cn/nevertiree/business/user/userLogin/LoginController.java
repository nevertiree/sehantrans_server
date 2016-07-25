package cn.nevertiree.business.user.userLogin;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Lance on 7/25/16.
 */

@Scope("prototype")
@Controller
@RequestMapping("/login")
public class LoginController {

   /* @Autowired
    LoginServiceIntf loginServiceIntf;
*/
    //以password的手段登录（假设还有其他的手段）
    @RequestMapping(value = "/pwd",method = RequestMethod.GET)
    @ResponseBody
    public String loginByPwd(LoginPwdVO pwdVO){
        //取得用户名和密码
        String name = pwdVO.getName();
        String pwd=pwdVO.getPwd();

        System.out.println("name="+name);

        /*//设置返回格式--》Map
        Map<String,Object> response=new HashMap<>();

        //如果以下函数返回true--》则success
        if (loginServiceIntf.loginByPwd(name,pwd)){
            response.put("success",true);
        }
        else response.put("success",false);*/

        //把数据用GSON打包并返回
        /*Gson gson=new Gson();
        return gson.toJson(response);*/

        return name;
    }
}
