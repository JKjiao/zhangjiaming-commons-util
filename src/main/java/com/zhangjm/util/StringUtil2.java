package com.zhangjm.util;

import java.util.Random;

public class StringUtil2 {

	/**
	 * �ж��ַ����Ƿ�Ϊ�գ�����ǿշ���True
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		if(str==null) {
			return true;
		}
		/**
		 * ȥ�ո�����Ϊ""������true
		 */
		str = str.trim();
		if("".equals(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * �ж��ַ�����Ϊ�գ�����һ�������෴
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
	
	/**
	 * �ж��Ƿ����ֻ�����
	 * @param str
	 * @return
	 */
	public static boolean isPhoneNum(String str) {
		String regex = "1[3578]\\d{9}";
		return str.matches(regex);
	}
	
	/**
	 * �ж��Ƿ�ȫ������
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		String regex = "/d";
		//������֤���÷������ַ���matches�Ƚ�������ʽ
		return str.matches(regex);
	}
	
	/**
	 * �ж��Ƿ�ȫ����ĸ
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
	 * �ж�������
	 * @param str
	 * @return
	 */
	public static boolean isEamil(String str) {
		String regex = "\\w+@\\w+.(com|cn|com.cn|net)";
		return str.matches(regex);
	}
	/**
	 * ��ȡһ������ַ�
	 * @return
	 */
	public static char getRandomChar() {
		Random random = new Random();
		char c = (char)('a'+random.nextInt(26));
		return c;
	}
	
	/**
	 * ��ȡһ���������
	 * @return
	 */
	public static char getRandomNumber() {
		Random random = new Random();
		char c = (char)('0'+random.nextInt(10));
		return c;
	}

	/**
	 * ���һ������ַ���(����+�ַ�)
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
