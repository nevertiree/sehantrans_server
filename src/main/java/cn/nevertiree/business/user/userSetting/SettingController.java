package cn.nevertiree.business.user.userSetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Lance on 7/26/16.
 */

@Scope("prototype")
@Controller
@RequestMapping(value = "/setting" ,method = RequestMethod.GET)
public class SettingController {

    @Autowired
    SettingServiceIntf settingServiceIntf;

}
