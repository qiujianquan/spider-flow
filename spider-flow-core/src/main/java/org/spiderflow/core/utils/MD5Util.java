package org.spiderflow.core.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;


/**
 * @ClassName: MD5Util
 * @Description:MD5加密/验证工具类
 * @author weny.yang
 * @date May 11, 2021
 */
public class MD5Util {

    /**
     * @Title: md5Lower
     * @Description:不加盐值32位小写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5Lower(String plainText) {
        String md5 = null;
        if (null != plainText && !"".equals(plainText)) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(plainText.getBytes("UTF-8"));
                md5 =  new BigInteger(1, md.digest()).toString(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return md5;
    }

    /**
     * @Title: md5Lower
     * @Description:加盐值32位小写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5Lower(String plainText, String saltValue) {
        String md5 = null;
        if (null != plainText && !"".equals(plainText) && null != saltValue && !"".equals(saltValue)) {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(plainText.getBytes("UTF-8"));
                md.update(saltValue.getBytes("UTF-8"));
                md5 = new BigInteger(1, md.digest()).toString(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return md5;
    }

    /**
     * @Title: md5_16Lower
     * @Description:不加盐值16位小写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5_16Lower(String plainText) {
        String md5 = md5Lower(plainText);
        return null==md5?md5:md5.substring(8, 24);
    }

    /**
     * @Title: md5_16Lower
     * @Description:加盐值16位小写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5_16Lower(String plainText, String saltValue) {
        String md5 = md5Lower(plainText, saltValue);
        return null==md5?md5:md5.substring(8, 24);
    }

    /**
     * @Title: md5_16Upper
     * @Description:不加盐值16位大写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5_16Upper(String plainText) {
        String md5 = md5_16Lower(plainText);
        return null==md5?md5:md5.toUpperCase();
    }

    /**
     * @Title: md5_16Upper
     * @Description:加盐值16位大写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5_16Upper(String plainText, String saltValue) {
        String md5 = md5_16Lower(plainText, saltValue);
        return null==md5?md5:md5.toUpperCase();
    }

    /**
     * @Title: md5Upper
     * @Description:不加盐值32位大写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5Upper(String plainText) {
        String md5 = md5Lower(plainText);
        return null==md5?md5:md5.toUpperCase();
    }

    /**
     * @Title: md5Upper
     * @Description:加盐值32位大写
     * @author weny.yang
     * @date May 11, 2021
     */
    public static String md5Upper(String plainText, String saltValue) {
        String md5 = md5Lower(plainText, saltValue);
        return null==md5?md5:md5.toUpperCase();
    }



    public static void main(String[] args) {



        UUID uuid = UUID.randomUUID();

        UUID uuid1 = UUID.randomUUID();

//        String uuid="af595d2c-de70-4981-9a15-4b716668e3fa";
//        String uuid1="b20a26a2-9de7-435d-8df1-bbdf5b6a5e16";

        System.out.println(uuid.toString());
        System.out.println(uuid1.toString());

        String v_key=uuid.toString().replaceAll("-","");
        String guid=uuid1.toString().replaceAll("-","");

//
//         v_key=uuid.toString();
//         guid=uuid1.toString();

         Integer pageNum=11;
         Integer pageSize=12;
        System.out.println(v_key);
        System.out.println(guid);

        String str=v_key+ guid + pageNum + "." + pageSize;
        System.out.println(str);
        String s = md5Lower(str);

        System.out.println(s);
        String a94fde68224497b868155b220310ef41 = "a94fde68224497b868155b220310ef41";
        if (s.equals(a94fde68224497b868155b220310ef41)) {
            System.out.println(true);
        }
        System.out.println(s);
        int i = s.charAt(5) + s.charAt(7) + s.charAt(9);

        System.out.println(i);



    }
}