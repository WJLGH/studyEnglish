package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ManagerBean;
import util.BackUpUtils;
import util.JDBCUtils;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Managermainfrm extends JFrame {
	private JPanel contentPane;
	private JDesktopPane Table = null;
	JMenuBar menuBar;
	JMenu basicMenu;
	JMenu wordManage;
	JMenuItem addWord;
	JMenuItem manageWord;
	JMenu vocabularyManageItem;
	JMenu DBManage;
	JMenu dbBackUpAndRecovery;
	JMenuItem dbBackUp;
	JMenuItem addVocabulary;
	JMenuItem dbRecovery;
	JMenu systemSecurity;
	JMenuItem aboutUsItem;
	JMenu aboutUs;
	JMenuItem vocabularyManage;
	JMenuItem modifyPwd;
	JMenuItem manageExit;
	private ManagerBean manager;

	/**
	 * Create the frame.
	 */
	public Managermainfrm(ManagerBean manager) {
		this.manager = manager;
		setTitle("管理员主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 401);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		basicMenu = new JMenu("基本数据维护       ");
		basicMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(basicMenu);

		wordManage = new JMenu("词汇维护");
		wordManage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		basicMenu.add(wordManage);

		addWord = new JMenuItem("增加词汇");
		addWord.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		addWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordaddActionPerformed(e);
			}
		});
		wordManage.add(addWord);

		manageWord = new JMenuItem("管理词汇");
		manageWord.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		manageWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordupdateActionPerformed(e);
			}
		});
		wordManage.add(manageWord);

		vocabularyManageItem = new JMenu("词汇表管理");
		vocabularyManageItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		basicMenu.add(vocabularyManageItem);

		addVocabulary = new JMenuItem("增加");
		addVocabulary.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		addVocabulary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordlistActionPerformed(e);
			}
		});
		vocabularyManageItem.add(addVocabulary);

		vocabularyManage = new JMenuItem("管理");
		vocabularyManage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		vocabularyManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordlistupdateActionPerformed(e);
			}
		});
		vocabularyManageItem.add(vocabularyManage);

		DBManage = new JMenu("数据库管理       ");
		DBManage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(DBManage);

		dbBackUpAndRecovery = new JMenu("数据库备份与还原");
		dbBackUpAndRecovery.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		DBManage.add(dbBackUpAndRecovery);

		dbBackUp = new JMenuItem("数据库备份");
		dbBackUp.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		dbBackUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backupActionPerformed(e);
			}
		});
		dbBackUpAndRecovery.add(dbBackUp);

		dbRecovery = new JMenuItem("数据库还原");
		dbRecovery.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		dbRecovery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbrecoveryActionPerformed(e);
			}
		});
		dbBackUpAndRecovery.add(dbRecovery);

		systemSecurity = new JMenu("系统安全      ");
		systemSecurity.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(systemSecurity);

		modifyPwd = new JMenuItem("修改密码");
		modifyPwd.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		modifyPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePwdActionPerformed(e);
			}
		});
		systemSecurity.add(modifyPwd);

		manageExit = new JMenuItem("安全退出");
		manageExit.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		manageExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否要退出系统");
				if (result == 0)
					manageExitActionPerformed(e);
					dispose();
			}
		});
		systemSecurity.add(manageExit);

		aboutUs = new JMenu("关于我们");
		aboutUs.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(aboutUs);

		aboutUsItem = new JMenuItem("关于我们");
		aboutUsItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		aboutUsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUsActionPerformed(e);
			}
		});
		aboutUs.add(aboutUsItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Table = new JDesktopPane();
		Table.setBackground(Color.GRAY);
		contentPane.add(Table, BorderLayout.CENTER);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
	}

	private void aboutUsActionPerformed(ActionEvent e) {
		AboutUs au = new AboutUs();
		Table.add(au);
	}

	private void dbrecoveryActionPerformed(ActionEvent e) {
		BackUpUtils.Recovery(null);
	}

	private void manageExitActionPerformed(ActionEvent e) {
		JDBCUtils.closeResource();
	}

	private void backupActionPerformed(ActionEvent e) {
		BackUpUtils.BackUp(null);
	}

	private void wordupdateActionPerformed(ActionEvent e) {
		Wordupdate word = new Wordupdate();
		word.setVisible(true);
		Table.add(word);

	}

	private void wordlistActionPerformed(ActionEvent e) {
		Wordlistadd wordlist = new Wordlistadd();
		wordlist.setVisible(true);
		Table.add(wordlist);
	}

	private void wordlistupdateActionPerformed(ActionEvent evt) {
		Wordlistupdate wordlist = new Wordlistupdate();
		wordlist.setVisible(true);
		Table.add(wordlist);

	}

	private void wordaddActionPerformed(ActionEvent evt) {
		Wordadd word = new Wordadd();
		word.setVisible(true);
		Table.add(word);
	}

	private void updatePwdActionPerformed(ActionEvent evt) {
		Mupdatepwdfrm updatepwd = new Mupdatepwdfrm(manager);
		updatepwd.setVisible(true);
		Table.add(updatepwd);
	}
}
