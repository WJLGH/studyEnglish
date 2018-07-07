package util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class BackUpUtils {

	/**
	 * ���ݿⱸ�� ͨ��Runtimeִ��һ��windows�µ�cmd����
	 * ������Windows��ͬʱmysql�Ŀͻ��ˣ�client�������ڻ�����������mysql�������
	 * 
	 * @param f
	 */
	public static void BackUp(JFrame f) {
		JFileChooser jf = new JFileChooser();
		int option = jf.showSaveDialog(f);
		if (option == JFileChooser.APPROVE_OPTION) {
			String path = jf.getSelectedFile().getAbsolutePath();
			System.out.println(path);
			Runtime runtime = Runtime.getRuntime();
			try {
				/**
				 * ���ݿⱸ������ ����֪�����ݿ�õ����ݵ�sql�ļ�
				 */
				runtime.exec("cmd /c mysqldump -h 123.207.14.231 -P 3306 -u root -ppp123456 studyEnglish  -r " + path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * ���ݿ⻹ԭ
	 * 
	 * @param f
	 */
	public static void Recovery(JFrame f) {
		JFileChooser jf = new JFileChooser();
		int option = jf.showOpenDialog(f);
		if (option == JFileChooser.APPROVE_OPTION) {
			String path = jf.getSelectedFile().getAbsolutePath();
			Runtime runtime = Runtime.getRuntime();
			try {
				/**
				 * ���ݿ⻹ԭ���� ��SQL�ļ���ԭ���Ѿ����ڵ����ݿ� mysql -hhostname -uusername -ppassword databasename
				 * < backupfile.sql
				 */
				runtime.exec("cmd /c mysql -h 123.207.14.231 -u root -ppp123456 studyEnglish < " + path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		BackUp(null);
	}
}
