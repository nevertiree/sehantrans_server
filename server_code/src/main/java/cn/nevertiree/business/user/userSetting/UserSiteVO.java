package cn.nevertiree.business.user.userSetting;

/**
 * Created by Lance on 7/31/16
 * Site包括 省 市 区 街道 和 路
 * province
 * city
 * county
 * district
 * street
 */
public class UserSiteVO {
    private String no;
    private String province;
    private String city;
    private String county;
    private String district;
    private String street;

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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
