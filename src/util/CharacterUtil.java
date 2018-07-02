package util;

import java.util.Scanner;

public class CharacterUtil {
	/**
	 * 判断给定字符串是否是否为空，为空返回true，否则返回false
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return "".equals(s);
	}
	/**
	 * 判定给定字符串是否为字母，含有非字母返回false，否则返回true
	 * @param s
	 * @return
	 */
	public static boolean isWord(String s) {
		s = s.toLowerCase();
		/**
		 * 注意：Character中的isLetter会把中文字符当成字母
		 */
		for(int i = 0 ;i < s.length();i++) {
			if(s.charAt(i)<'a'||s.charAt(i)>'z') {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		while (in.hasNext()) {
			String s = in.nextLine();
			System.out.println(isWord(s));
		}
	}
}
