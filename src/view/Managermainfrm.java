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
		setTitle("\u7BA1\u7406\u5458\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 401);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		basicMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4       ");
		basicMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(basicMenu);

		wordManage = new JMenu("\u8BCD\u6C47\u7EF4\u62A4");
		wordManage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		basicMenu.add(wordManage);

		addWord = new JMenuItem("\u589E\u52A0\u8BCD\u6C47");
		addWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordaddActionPerformed(e);
			}
		});
		wordManage.add(addWord);

		manageWord = new JMenuItem("\u7BA1\u7406\u8BCD\u6C47");
		manageWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordupdateActionPerformed(e);
			}
		});
		wordManage.add(manageWord);

		vocabularyManageItem = new JMenu("\u8BCD\u6C47\u8868\u7EF4\u62A4");
		vocabularyManageItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		basicMenu.add(vocabularyManageItem);

		addVocabulary = new JMenuItem("\u589E\u52A0");
		addVocabulary.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		addVocabulary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordlistActionPerformed(e);
			}
		});
		vocabularyManageItem.add(addVocabulary);

		vocabularyManage = new JMenuItem("\u7BA1\u7406");
		vocabularyManage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		vocabularyManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordlistupdateActionPerformed(e);
			}
		});
		vocabularyManageItem.add(vocabularyManage);

		DBManage = new JMenu("\u6570\u636E\u5E93\u7BA1\u7406          ");
		DBManage.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(DBManage);

		dbBackUpAndRecovery = new JMenu("\u6570\u636E\u5E93\u5907\u4EFD\u4E0E\u8FD8\u539F");
		dbBackUpAndRecovery.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		DBManage.add(dbBackUpAndRecovery);

		dbBackUp = new JMenuItem("\u6570\u636E\u5E93\u5907\u4EFD");
		dbBackUp.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		dbBackUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backupActionPerformed(e);
			}
		});
		dbBackUpAndRecovery.add(dbBackUp);

		dbRecovery = new JMenuItem("\u6570\u636E\u5E93\u8FD8\u539F");
		dbRecovery.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		dbRecovery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbrecoveryActionPerformed(e);
			}
		});
		dbBackUpAndRecovery.add(dbRecovery);

		systemSecurity = new JMenu("\u7CFB\u7EDF\u5B89\u5168      ");
		systemSecurity.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 25));
		menuBar.add(systemSecurity);

		modifyPwd = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		modifyPwd.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		modifyPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePwdActionPerformed(e);
			}
		});
		systemSecurity.add(modifyPwd);

		manageExit = new JMenuItem("\u9000\u51FA");
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

		aboutUs = new JMenu("\u5173\u4E8E\u6211\u4EEC");
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
