/*
package cn.nevertiree.business.user.userSetting.setInfo;

import cn.nevertiree.business.user.userSetting.dvo.UserNameVO;
import cn.nevertiree.business.user.userSetting.getInfo.SettingGetController;
import cn.nevertiree.business.user.userSetting.getInfo.SettingGetServiceIntf;
import cn.nevertiree.common.JsonUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

*/
/**
 * Created by Lance on 8/10/16.
 *//*

public class SettingGetControllerTest {

    */
/*@Autowired
    SettingGetController settingGetController;

    //mock一个接口
    private SettingGetServiceIntf intf = mock(SettingGetServiceIntf.class);

    private Map<String ,Object> response = new HashMap<String, Object>();
*//*


    @Test
    public void testGetName(){
        UserNameVO userNameVO = mock(UserNameVO.class);

*/
/*        //第一种情况 返回正确的值wlx
        userNameVO.setNo("0001");
        when(intf.getName("0001")).thenReturn("wlx");
        response.clear();
        String result = settingGetController.getName(userNameVO);
        verify(intf).getName("0001");
        Assert.assertEquals("wlx",result);*//*


        //第二种情况 返回null值
        when(intf.getName("0002")).thenReturn(null);
        String name2 = intf.getName("0002");
        verify(intf).getName("0002");
        Assert.assertEquals(null,name2);
    }

    @Test
    public void testGetPwd(){
        //第一种情况，返回正确的pwd
        when(intf.getPwd("0001")).thenReturn("pwd");
        String pwd1 = intf.getPwd("0001");
        verify(intf).getPwd("0001");
        Assert.assertEquals("pwd",pwd1);

        //第二种情况，返回null
        when(intf.getPwd("0002")).thenReturn(null);
        String pwd2 = intf.getPwd("0002");
        verify(intf).getPwd("0002");
        Assert.assertEquals(null,pwd2);

    }
    //public void testGetGender();
    //public void testGetBirth();
    //public void testGetMobile();
    //public void testGetEmail();
    //public void testGetSite();
    //public void testGetPortrait();
    //public void testGetIntroduction();

}
*/
