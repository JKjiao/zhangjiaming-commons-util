package com.zhangjm.util;

import java.util.Random;

public class StringUtil2 {

	/**
	 * 判断字符串是否为空，如果是空返回True
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if(str==null) {
			return true;
		}
		/**
		 * 去空格后，如果为""，返回true
		 */
		str = str.trim();
		if("".equals(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串不为空，和上一个方法相反
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
	
	/**
	 * 判断是否是手机号码
	 * @param str
	 * @return
	 */
	public static boolean isPhoneNum(String str) {
		String regex = "1[3578]\\d{9}";
		return str.matches(regex);
	}
	
	/**
	 * 判断是否全是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		String regex = "/d";
		//正则验证的用法，用字符串matches比较正则表达式
		return str.matches(regex);
	}
	
	/**
	 * 判断是否全是字母
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String str) {
		if(isNull(str)) {
			return false;
		}
		str = str.toLowerCase();
		String regex = "[a-z]+";
		return str.matches(regex);
	}
	
	/**
	 * 判断是邮箱
	 * @param str
	 * @return
	 */
	public static boolean isEamil(String str) {
		String regex = "\\w+@\\w+.(com|cn|com.cn|net)";
		return str.matches(regex);
	}
	/**
	 * 获取一个随机字符
	 * @return
	 */
	public static char getRandomChar() {
		Random random = new Random();
		char c = (char)('a'+random.nextInt(26));
		return c;
	}
	
	/**
	 * 获取一个随机数字
	 * @return
	 */
	public static char getRandomNumber() {
		Random random = new Random();
		char c = (char)('0'+random.nextInt(10));
		return c;
	}

	/**
	 * 获得一个随机字符串(数字+字符)
	 * @param num
	 * @return
	 */
	public static String getRandomCharAndNumber(int num) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i=0;i<num;i++) {
			int randomNum = random.nextInt(36);
			if(randomNum > 10) {
				char c = getRandomChar();
			}else {
				char c = getRandomNumber();
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static String randomChineseString() {
		String str = null;
		int highPos,lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(39)));
		return str;
	}
}
