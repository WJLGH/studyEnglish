package util;

import java.util.Scanner;

public class CharacterUtil {
	// �Զ���� �ٶ�api������Ϣ
	public static String ERROR = "û���ҵ�";

	/**
	 * �жϸ����ַ����Ƿ��Ƿ�Ϊ�գ�Ϊ�շ���true�����򷵻�false
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isEmpty(String s) {
		return s == null||"".equals(s.trim());
	}

	/**
	 * �ж������ַ����Ƿ�Ϊ��ĸ�����з���ĸ����false�����򷵻�true
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
		 * ע�⣺Character�е�isLetter��������ַ�������ĸ
		 */
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
				return false;
			}
		}
		return true;
	}
	/**
	 * �Ѷ��������зָ�
	 * ���һ����˼�����зֺ�
	 * @param ml
	 * @return
	 */
	public static String[] meaningStrToArray(String ml) {
		return ml.split("[��;]");
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
