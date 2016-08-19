package cn.nevertiree.business.user.userSetting.dvo;

/**
 * Created by Lance on 8/8/16.
 */
public class UserSiteVO extends UserSettingType {

    private String province;
    private String city;
    private String county;
    private String district;
    private String street;
    private String school;

    int getTypeCode(){
        return UserSettingType.SITE;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    /**取得或者修改信息*/

    public UserSettingType getInfo(UserSettingType userSettingType){
        return null;
    }

    public boolean setInfo(UserSettingType userSettingType){
        return false;
    }

}
