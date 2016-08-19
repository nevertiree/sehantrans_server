package cn.nevertiree.business.user.userSetting.dvo;

import cn.nevertiree.business.dao.UserpersoninfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * Created by Lance on 8/8/16.
 */

public class UserBirthVO extends UserSettingType {

    @Autowired
    UserpersoninfoMapper userpersoninfoMapper;

    private Timestamp birth;

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    int getTypeCode(){
        return UserSettingType.BIRTH;
    }

    /**取得或者修改信息*/

    public UserSettingType getInfo(UserSettingType userSettingType){

        String no = userSettingType.getNo();

        Timestamp birth = userpersoninfoMapper.getBirth(no);

        UserBirthVO returnValue = new UserBirthVO();

        returnValue.setBirth(birth);

        return returnValue;
    }

    public boolean setInfo(UserSettingType userSettingType){

        /*如果没有被操作的行就返回false*/
        return userpersoninfoMapper.setBirth((UserBirthVO)userSettingType)!=0;
    }
}
