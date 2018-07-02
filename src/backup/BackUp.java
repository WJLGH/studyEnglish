package backup;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class BackUp extends JFrame implements ActionListener{
	JButton save = new JButton("save");
	JButton recovery = new JButton("recovery");
	public BackUp() {
		getContentPane().add(save,BorderLayout.NORTH);
		getContentPane().add(recovery,BorderLayout.SOUTH);
		save.addActionListener(this);
		recovery.addActionListener(this);
		setSize(500, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BackUp();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == save) {
			
			JFileChooser jf = new JFileChooser();
			int option = jf.showSaveDialog(this);
			if(option==JFileChooser.APPROVE_OPTION) {
				String path = jf.getSelectedFile().getAbsolutePath();
				Runtime runtime = Runtime.getRuntime();
				try {
					/**
					 * 数据库备份命令
					 * 	从已知的数据库得到备份的sql文件
					 */
					runtime.exec("cmd /c mysqldump -h localhost -u root -proot db_book > "+ path);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else {
			JFileChooser jf = new JFileChooser();
			int option = jf.showOpenDialog(this);
			if(option==JFileChooser.APPROVE_OPTION) {
				String path = jf.getSelectedFile().getAbsolutePath();
				Runtime runtime = Runtime.getRuntime();
				try {
					/**
					 * 数据库还原命令
					 * 以SQL文件还原到已经存在的数据库
					 * mysql -hhostname -uusername -ppassword databasename < backupfile.sql
					 */
					runtime.exec("cmd /c mysql -h 123.207.14.231 -u root -ppp123456 test < "+ path);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}	
