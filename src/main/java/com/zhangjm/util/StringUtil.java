package com.zhangjm.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Random;

public class StringUtil {

	
	/**
	 * 校验传入的参数是否为url
	 * @param param
	 * @return
	 */
	public static boolean isHttpUrl(String param) {
		 URL url;  
		 try {  
	         url = new URL(param);
	        url.openStream();  
	         return true; //url合法
	    } catch (Exception e1) {  
	         System.out.println("连接打不开!");  
	       
	    }  
		 return false;
		
	}

	// 方法1：判断源字符串是否有值，空引号(空白字符串)也算没值 (5分)
	public static boolean hasLength(CharSequence src) {
		return null != src && src.length() > 0;
	}

	// 方法2：判断源字符串是否有值，空引号(空白字符串)和空格也算没值 (5分)
	public static boolean hasText(String src) {
		return null != src && src.trim().length() > 0;
	}
	/**
	 * @Title: isNull   
	 * @Description: �ж��ַ����Ƿ�Ϊ��   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isNull(String str) {
		if(str==null) {
			return true;
		}
		/** ȥ�ո�����Ϊ"",����true **/
		str = str.trim();
		if("".equals(str)) {
			return true;
		}
		return false;
	}
	/**
	 * @Title: isNotNull   
	 * @Description: �ж��ַ�����Ϊ��   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
	/**
	 * @Title: isPhoneNum   
	 * @Description: �Ƿ�Ϊ�ֻ���   18618109887
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isPhoneNum(String str) {
		String regex = "1[3578]\\d{9}";
		return str.matches(regex);
	}
	
	public static boolean isNumber(String str) {
		String regex = "/d";
		return str.matches(regex); 
	}
	/**
	 * @Title: isEmail   
	 * @Description: �ж��Ƿ�Ϊ���� zhanggm1002@qq.com   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean isEmail(String str) {
		String regex = "\\w+@\\w+.(com|cn|com.cn|net)";
		return str.matches(regex);
	}
	/**
	 * @Title: isLetter   
	 * @Description: �ж��Ƿ�ȫΪ��ĸ   
	 * @param: @param str
	 * @param: @return      
	 * @return: boolean      
	 * @throws
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
	 * @Title: getRandomChar   
	 * @Description: ������һ���ַ�   
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static char getRandomChar() {
		Random random = new Random();
		char c = (char)('a'+random.nextInt(26));
		return c;
	}
	/**
	 * @Title: getRandomChar   
	 * @Description: ���ָ��λ��������ַ�   
	 * @param: @param num
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getRandomChar(int num) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<num;i++) {
			char c = getRandomChar();
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * @Title: getRandomNumber   
	 * @Description: ����������   
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static char getRandomNumber() {
		Random random = new Random();
		char c = (char)('0'+random.nextInt(10));
		return c;
	}
	
	/**
	 * @Title: getRandomCharAndNumber   
	 * @Description: �������ַ���������+�ַ���   
	 * @param: @param num
	 * @param: @return      
	 * @return: char      
	 * @throws
	 */
	public static String getRandomCharAndNumber(int num) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i=0;i<num;i++) {
			int randomNum = random.nextInt(36);
			if(randomNum>10) {
				char c = getRandomChar();
				sb.append(c);
			}else {
				char c = getRandomNumber();
				sb.append(c);
			}
		}
		return sb.toString();
	}
	/**
	 * @Title: randomChineseString   
	 * @Description: �������   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseString() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(39)));// ���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(94));// λ�룬0xA0��ͷ����Χ��1~94��
		byte[] bArr = new byte[2];
		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312"); // ��λ����ϳɺ���
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * @Title: randomChineseString   
	 * @Description: ����������   
	 * @param: @param num
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseString(int num) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<num;i++) {
			String randomChineseString = randomChineseString();
			sb.append(randomChineseString);
		}
		return sb.toString();
	}
	/**
	 * @Title: randomChineseName   
	 * @Description: �ټ��� ��������  
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String randomChineseName() {
		String[] surname = { "��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��", "��", "л", "��", "��", "��", "ˮ", "�",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "³", "Τ", "��", "��", "��", "��", "��", "��", "��", "��", "Ԭ", "��",
				"ۺ", "��", "ʷ", "��", "��", "��", "�", "Ѧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "ʱ", "��", "Ƥ", "��", "��", "��", "��", "��", "Ԫ", "��", "��", "��", "ƽ", "��", "��", "��", "��", "��", "Ҧ", "��",
				"տ", "��", "��", "ë", "��", "��", "��", "��", "��", "�", "��", "��", "��", "��", "̸", "��", "é", "��", "��", "��", "��",
				"��", "��", "ף", "��", "��", "��", "��", "��", "��", "ϯ", "��", "��", "ǿ", "��", "·", "¦", "Σ", "��", "ͯ", "��", "��",
				"÷", "ʢ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "֧", "��", "��",
				"��", "¬", "Ī", "��", "��", "��", "��", "��", "��", "Ӧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "ʯ", "��", "��", "ť", "��", "��", "��", "��", "��", "��", "½", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɽ", "��",
				"��", "��", "�", "��", "ȫ", "ۭ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ղ", "��", "��", "Ҷ", "��", "˾", "��", "۬", "��", "��", "��", "ӡ", "��", "��", "��", "��", "ۢ",
				"��", "��", "��", "��", "��", "��", "׿", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "˫", "��", "ݷ", "��",
				"��", "̷", "��", "��", "��", "��", "��", "��", "��", "Ƚ", "��", "۪", "Ӻ", "ȴ", "�", "ɣ", "��", "�", "ţ", "��", "ͨ",
				"��", "��", "��", "��", "��", "��", "ũ", "��", "��", "ׯ", "��", "��", "��", "��", "��", "Ľ", "��", "��", "ϰ", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "»", "��", "��", "ŷ", "�", "��", "��", "ε", "Խ", "��", "¡", "ʦ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɳ", "ؿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "ۣ", "��", "Ȩ", "��", "��", "��", "��", "��", "��", "��", "��", "˧", "��", "��", "��", "�C", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "۳", "Ϳ", "��", "��", "Ĳ", "��", "٦", "��", "��", "ī", "��", "��", "��",
				"��", "��", "��", "١", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "չ", "��", "̴", "��", "��", "��", "��",
				"˴", "¥", "��", "ð", "��", "ֿ", "��", "��", "��", "��", "ԭ", "��", "��", "��", "��", "��", "�", "��", "��", "��", "�",
				"��", "��", "��", "��", "��", "��", "��", "ľ", "��", "��", "ۨ", "��", "ö", "��", "��", "�", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "�G", "��ٹ", "˾��", "�Ϲ�", "ŷ��",
				"�ĺ�", "���", "����", "����", "����", "�ʸ�", "����", "ξ��", "����", "�̨", "��ұ", "����", "���", "����", "����", "̫��", "����",
				"����", "����", "��ԯ", "���", "����", "����", "����", "Ľ��", "����", "����", "˾ͽ", "˾��", "أ��", "˾��", "����", "����", "�ӳ�",
				"���", "��ľ", "����", "����", "���", "����", "����", "����", "�ذ�", "�й�", "�׸�", "����", "�θ�", "����", "����", "΢��", "����",
				"����", "����", "����", "�Ϲ�", "����", "����", "����", "̫ʷ", "�ٳ�", "����", "��ͻ", "����", "����", "����", "��ĸ", "˾��", "����",
				"Ӻ��", "����", "����", "����", "��®", "����", "�Ϲ�", "����", "����" };
		// �����ȡ����
		String name1 = surname[RandomUtil.random(0, surname.length - 1)];
		// �����ȡ1-2������
		String name2 = randomChineseString(RandomUtil.random(1, 3));
		return name1 + name2;
	}
	
	public static boolean judgeTelephoneIsOk(String src){
		String phone = "1\\d{10}";
		return src.matches(phone);
		
	}
	
	public static void main(String[] args) {
		boolean judgeTelephoneIsOk = StringUtil.judgeTelephoneIsOk("13870664089");
		System.out.println(judgeTelephoneIsOk);
		
	}
}
