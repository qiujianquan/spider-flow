package org.spiderflow.core.utils;

import org.jsoup.Connection;

import java.beans.Encoder;
import java.security.MessageDigest;
import java.util.UUID;

public class MD5 {
    /**
     * 获得MD5加密密码的方法
     */
    public static String getMD5ofStr(String origString) {
        String origMD5 = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] result = md5.digest(origString.getBytes());
            origMD5 = byteArray2HexStr(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return origMD5;
    }

    /**
     * 处理字节数组得到MD5密码的方法
     */
    private static String byteArray2HexStr(byte[] bs) {
        StringBuffer sb = new StringBuffer();
        for (byte b : bs) {
            sb.append(byte2HexStr(b));
        }
        return sb.toString();
    }

    /**
     * 字节标准移位转十六进制方法
     */
    private static String byte2HexStr(byte b) {
        String hexStr = null;
        int n = b;
        if (n < 0) {
            //若需要自定义加密,请修改这个移位算法即可  
            n = b & 0x7F + 128;
        }
        hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
        return hexStr.toUpperCase();
    }

    /**
     * 提供一个MD5多次加密方法
     */
    public static String getMD5ofStr(String origString, int times) {
        String md5 = getMD5ofStr(origString);
        for (int i = 0; i < times - 1; i++) {
            md5 = getMD5ofStr(md5);
        }
        return getMD5ofStr(md5);
    }

    /**
     * 密码验证方法
     */
    public static boolean verifyPassword(String inputStr, String MD5Code) {
        return getMD5ofStr(inputStr).equals(MD5Code);
    }

    /**
     * 重载一个多次加密时的密码验证方法
     */
    public static boolean verifyPassword(String inputStr, String MD5Code, int times) {
        return getMD5ofStr(inputStr, times).equals(MD5Code);
    }

    /**
     * 获得MD5加密后的字符串
     *
     * @param s
     * @return String
     * @author fengxiaoshuai
     * @date 2011-11-8-下午01:45:38
     */
    public final static String getMD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    public static void main(String[] args) {


//        String uuid="6b3119e2-d98c-4518-88aa-42206cf91330";
//        Integer pageSize = 12;
//        Integer pageNum = 1;
//        String v_key = "e884e892-19e0-4c1b-8f42-08e3aa76e80c";
////           /*前端拦截器post请求，采用MD5算法对v_key、guid和分页参数组合字符串加密；
////                    将加密后的字符串 取3、6、9位字符的ASCII形成一个数值型，并加入到post请求的参数，参数名为number*/
//        String md5Str = MD5.getMD5((v_key + uuid + pageNum + "." + pageSize));
//            var number = md5Str.charCodeAt(5) + md5Str.charCodeAt(7) + md5Str.charCodeAt(9);

//879d1e9f-adcb-42e49a243-ea0a718a616
//e884e892-19e0-4c1b-8f42-08e3aa76e80c
        String a="879d1e9f-adcb-42e49a243-ea0a718a616";
        String b="e884e892-19e0-4c1b-8f42-08e3aa76e80c";

        System.out.println(a.length());
        System.out.println(b.length());


//            参数值： 8ec3cd55-1c7f-42db-a81a-f58c6374136ffeeea27d-282e-4566-91e8-490f5d2c19a92.12

//        System.out.println(md5Str);


        UUID uuid = UUID.randomUUID();

        UUID uuid1 = UUID.randomUUID();

//        String uuid="8ec3cd55-1c7f-42db-a81a-f58c6374136f";
//        String uuid1="feeea27d-282e-4566-91e8-490f5d2c19a9";

        System.out.println(uuid.toString());
        System.out.println(uuid1.toString());

        String str=uuid.toString() + uuid1.toString() + 3 + "," + 12;
        System.out.println(str);

        int i = str.charAt(5) + str.charAt(7) + str.charAt(9);

        System.out.println(i);

    }
} 