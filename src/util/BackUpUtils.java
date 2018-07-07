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
	 * 数据库备份 通过Runtime执行一条windows下的cmd命令
	 * 必须是Windows下同时mysql的客户端（client）并且在环境变量中有mysql这个命令
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
				 * 数据库备份命令 从已知的数据库得到备份的sql文件
				 */
				runtime.exec("cmd /c mysqldump -h 123.207.14.231 -P 3306 -u root -ppp123456 studyEnglish  -r " + path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 数据库还原
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
				 * 数据库还原命令 以SQL文件还原到已经存在的数据库 mysql -hhostname -uusername -ppassword databasename
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
