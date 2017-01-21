package cn.nevertiree.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lance on 17-1-21.
 */
public class RegexUtil {

    public static boolean correctMobile(String mobile){
        Pattern pattern = Pattern.compile("^[\\d]{11}$");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.find();
    }

    public static boolean correctEmail(String email){
        Pattern pattern = Pattern.compile("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
}
