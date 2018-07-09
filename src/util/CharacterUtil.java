package util;

import java.util.Scanner;

public class CharacterUtil {
	// 自定义的 百度api错误信息
	public static String ERROR = "没有找到";

	/**
	 * 判断给定字符串是否是否为空，为空返回true，否则返回false
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return s == null||"".equals(s.trim());
	}

	/**
	 * 判定给定字符串是否为字母，含有非字母返回false，否则返回true
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isWord(String s) {
		if(s == null) {
			return false;
		}
		s = s.toLowerCase();
		/**
		 * 注意：Character中的isLetter会把中文字符当成字母
		 */
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
				return false;
			}
		}
		return true;
	}
	/**
	 * 把多个释义进行分割
	 * 最后一个意思后不能有分号
	 * @param ml
	 * @return
	 */
	public static String[] meaningStrToArray(String ml) {
		return ml.split("[；;]");
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String s = in.nextLine();
			String [] ar = meaningStrToArray(s);
			for (String string : ar) {
				System.out.println(string);
			}
		}
	}
}
