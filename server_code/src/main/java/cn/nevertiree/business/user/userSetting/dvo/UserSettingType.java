package cn.nevertiree.business.user.userSetting.dvo;

/**
 * Created by Lance on 8/14/16.
 * 用户信息管理的基本类 包含验证用户的基本内容
 */
public abstract class UserSettingType {

    private String no;
    private String token;
    private String ip;
    private int typeCode;//要修改的信息的内容：类型码

    public static final int NAME = 1;
    public static final int PWD =2;
    public static final int GENDER = 3;
    public static final int BIRTH = 4;
    public static final int EMAIL = 5;
    public static final int MOBILE = 6;
    public static final int SITE = 7;
    public static final int PORTRAIT = 8;
    public static final int INTRODUCTION = 9;

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    abstract int getTypeCode();

    public abstract UserSettingType getInfo(UserSettingType userSettingType);

    public abstract boolean setInfo(UserSettingType userSettingType);

    static UserSettingType newType(int code){
        switch (code){
            case NAME:
                return new UserNameVO();
            case PWD:
                return new UserPwdVO();
            case GENDER:
                return new UserGenderVO();
            case BIRTH:
                return new UserBirthVO();
            case EMAIL:
                return new UserEmailVO();
            case MOBILE:
                return new UserMobileVO();
            case SITE:
                return new UserSiteVO();
            case PORTRAIT:
                return new UserPortraitVO();
            case INTRODUCTION:
                return new UserIntroductionVO();
            default:
                throw new RuntimeException("Incorrect Type");
        }
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
