package cn.nevertiree.common;

import com.google.gson.Gson;

/**
 * Created by Lance on 7/31/16.
 */
public class JsonUtil {

    static Gson gson=new Gson();

    public static String toJson(Object object){
        return gson.toJson(object);
    }
}
