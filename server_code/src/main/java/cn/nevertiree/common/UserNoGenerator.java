package cn.nevertiree.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import javax.xml.crypto.Data;
import javax.xml.crypto.dsig.DigestMethod;
import java.text.SimpleDateFormat;

/**
 * Created by Lance on 7/26/16.
 */

//本方法用与生成用户ID

public class UserNoGenerator {

    @Autowired
    Data data;

    @Autowired
    SimpleDateFormat simpleDateFormat;

    @Autowired
    DigestUtils digestUtils;

    public String getUserNo(String name){
        String date = simpleDateFormat.format(data);

        String originNo=name+date;

        String userNo= DigestMethod.SHA1;

        return "";
    }

}
