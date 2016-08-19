package cn.nevertiree.business.user.userSetting.dvo;

/**
 * Created by Lance on 8/8/16.
 */
public class UserNameVO extends UserSettingType {

    private String name;

    int getTypeCode(){
        return UserSettingType.NAME;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**取得或者修改信息*/

    public UserSettingType getInfo(UserSettingType userSettingType){
        return null;
    }

    public boolean setInfo(UserSettingType userSettingType){
        return false;
    }
}
