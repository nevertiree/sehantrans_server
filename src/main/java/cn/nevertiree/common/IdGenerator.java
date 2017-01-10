package cn.nevertiree.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Lance on 7/26/16.
 */

//本方法用与生成各种各样的ID

public class IdGenerator {

    //把数据通过SHA-512加密算法 得到byte密文
    public static byte[] sha(String message){

        byte[] shaEncode = null;

        try {
            //选用数据加密类中的SHA算法
            MessageDigest shaDigest = MessageDigest.getInstance("SHA-512");

            //把message转换成byte然后再用SHA加密
            shaEncode = shaDigest.digest(message.getBytes());

        }catch (NoSuchAlgorithmException e){//无该种算法异常
            e.printStackTrace();
        }
        finally {
            //返回加密后的值
            return shaEncode;
        }
    }

    //将Byte密文转换为16进制字符串输出
    public static String convertByteToHexString(byte[] bytes){
        String result="";
        for (int i=0;i<bytes.length;i++){
            int temp=bytes[i] & 0xff;
            String tempHex=Integer.toHexString(temp);
            if (tempHex.length()<2)
                result += "0" + tempHex;
            else result += tempHex;
        }
        return result;
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            stringBuffer.append(base.charAt(number));
        }
        return stringBuffer.toString();
    }

    //返回初始值和注册时间以及一串随机字符
    public static String getOriginId(String name){
        //用户注册日
        String date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());

        //随机值
        String randomValue=getRandomString(32);

        //没有加密过的No
        return name+date+randomValue;
    }

    //返回初始值和注册时间以及一串随机字符
    public static String getOriginId(){
        //用户注册日
        String date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());

        //随机值
        String randomValue=getRandomString(32);

        //没有加密过的No
        return date+randomValue;
    }


    //把初始的值通过SHA-512算法处理生成唯一的64位数字签名
    public static String getHashId(String name){
        //取的混合name
        String originName = getOriginId(name);
        //取的加密后的混合name
        String encodeName = convertByteToHexString(sha(originName));
        //取前16位
        return encodeName.substring(0,63);
    }

    public static String getHashId(){
        //取的混合name
        String originName = getOriginId();
        //取的加密后的混合name
        String encodeName = convertByteToHexString(sha(originName));
        //取前16位
        return encodeName.substring(0,63);
    }
}
