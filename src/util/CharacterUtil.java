package util;

import java.util.Scanner;

public class CharacterUtil {
	/**
	 * �жϸ����ַ����Ƿ��Ƿ�Ϊ�գ�Ϊ�շ���true�����򷵻�false
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return "".equals(s);
	}
	/**
	 * �ж������ַ����Ƿ�Ϊ��ĸ�����з���ĸ����false�����򷵻�true
	 * @param s
	 * @return
	 */
	public static boolean isWord(String s) {
		s = s.toLowerCase();
		/**
		 * ע�⣺Character�е�isLetter��������ַ�������ĸ
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
