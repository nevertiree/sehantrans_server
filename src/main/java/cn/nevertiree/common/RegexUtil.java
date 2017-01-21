package cn.nevertiree.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lance on 17-1-21.
 */

public class RegexUtil {

    public static boolean checkPassword(String password){
        // length control
        if (password.length()<6 || password.length()>20 || password.equals(""))
            return false;
        // contain digit
        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(password);
        if (!digitMatcher.find())
            return false;
        // contain character
        Pattern charPattern = Pattern.compile("[a-zA-Z]");
        Matcher charMatcher = charPattern.matcher(password);
        if (!charMatcher.find())
            return false;
        // contain special
        Pattern specialPattern = Pattern.compile("[~!@#$%^&*()_+|<>,.?/:;'\\\\[\\\\]{}\\\"]");
        Matcher specialMatcher = specialPattern .matcher(password);
        return !(specialMatcher.find());
    }

    public static boolean checkMobile(String mobile){
        Pattern pattern = Pattern.compile("^[\\d]{11}$");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.find();
    }

    public static boolean checkEmail(String email){
        Pattern pattern = Pattern.compile("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

}
