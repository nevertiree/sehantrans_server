package cn.nevertiree.business.user.userSetting.dvo;

import java.io.File;

/**
 * Created by Lance on 8/8/16.
 */
public class UserPortraitVO {

    private String no;
    private File   portrait;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public File getPortrait() {
        return portrait;
    }

    public void setPortrait(File portrait) {
        this.portrait = portrait;
    }
}
