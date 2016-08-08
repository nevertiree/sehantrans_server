package cn.nevertiree.business.user.userSetting.dvo;

/**
 * Created by Lance on 8/8/16.
 */
public class UserIntroductionVO {
    private String no;
    private byte[] introduction;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public byte[] getIntroduction() {
        return introduction;
    }

    public void setIntroduction(byte[] introduction) {
        this.introduction = introduction;
    }
}
