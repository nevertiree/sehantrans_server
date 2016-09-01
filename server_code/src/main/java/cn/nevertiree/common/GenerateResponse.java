package cn.nevertiree.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lance on 8/22/16.
 */

@Service
public class GenerateResponse {

    public static String generateResponse(boolean isSuccess,String msg){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",isSuccess);
        result.put("msg",msg);
        return JsonUtil.toJson(result);
    }

    public static String generateResponse(boolean isSuccess,String msg,Object object){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",isSuccess);
        result.put("msg",msg);
        result.put("object",object);
        return JsonUtil.toJson(result);
    }
}
