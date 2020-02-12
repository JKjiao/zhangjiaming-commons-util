package com.zhangjm.util;

import java.security.MessageDigest;

/**
 * @Description:閲囩敤MD5鍔犲瘑瑙ｅ瘑   
 * @author: zhanggm1002
 * @date:   2019骞�12鏈�13鏃� 涓婂崍8:46:51
 */
public class Md5Util {
    /**
     * @Title: string2MD5   
     * @Description: MD5鍔犵爜 鐢熸垚32浣峬d5鐮�  
     * @param: @param inStr
     * @param: @return      
     * @throws
     */
    public static String string2MD5(String inStr){  
        MessageDigest md5 = null;  
        try{  
            md5 = MessageDigest.getInstance("MD5");  
        }catch (Exception e){  
            System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++){  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        return hexValue.toString();  
  
    }  
  
    /**
     * @Title: convertMD5   
     * @Description: 鍔犲瘑瑙ｅ瘑绠楁硶 鎵ц涓�娆″姞瀵嗭紝涓ゆ瑙ｅ瘑  
     * @param: @param inStr
     * @param: @return      
     * @return: String      
     * @throws
     */
    public static String convertMD5(String inStr){  
        char[] a = inStr.toCharArray();  
        for (int i = 0; i < a.length; i++){  
            a[i] = (char) (a[i] ^ '9');  
        }  
        String s = new String(a);
        return s;
    }  
    
    public static void main(String[] args) {
		String string2md5 = Md5Util.string2MD5("123456");
		System.out.println(string2md5);
	}
}

