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

    public static Object fromJson(String jsonString,String type){
        try {
            return gson.fromJson(jsonString,Class.forName(type));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
