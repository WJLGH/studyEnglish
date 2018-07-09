package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.UserBean;
import util.JDBCUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class Usermainfrm extends JFrame {

	private JPanel contentPane;
	JDesktopPane Table = null;
	private UserBean user;

	/**
	 * Create the frame.
	 */
	public Usermainfrm(UserBean user) {
		this.user = user;
		setTitle("\u7528\u6237\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 765);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mydictionarymenu = new JMenu("\u6211\u7684\u8BCD\u5178       ");
		mydictionarymenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		mydictionarymenu.setIcon(new ImageIcon(Usermainfrm.class.getResource("/image/bookManager.png")));
		menuBar.add(mydictionarymenu);
		
		JMenuItem myachievemenu = new JMenuItem("我的成就");
		myachievemenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		myachievemenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				achieveActionPerformed(e);
			}
		});
		mydictionarymenu.add(myachievemenu);
		
		JMenuItem recitemenu = new JMenuItem("背诵单词");
		recitemenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		recitemenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reciteActionPerforemd(e);
			}
		});
		mydictionarymenu.add(recitemenu);
		
		JMenuItem mycollectButton = new JMenuItem("我的收藏");
		mycollectButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		mycollectButton.setIcon(null);
		mycollectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mycollectActionPerformed(e);
			}
		});
		mydictionarymenu.add(mycollectButton);
		
		JMenuItem searchButton = new JMenuItem("查找单词");
		searchButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		searchButton.setIcon(null);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchActionPerformed(e);
			}
		});
		mydictionarymenu.add(searchButton);
		
		JMenuItem reviewButton = new JMenuItem("复习单词");
		reviewButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		reviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reviewActionPerformed(e);
			}
		});
		mydictionarymenu.add(reviewButton);
		
		JMenu securitymenu = new JMenu("\u5B89\u5168        ");
		securitymenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		securitymenu.setIcon(new ImageIcon(Usermainfrm.class.getResource("/image/base.png")));
		menuBar.add(securitymenu);
		
		JMenuItem updatepwdButton = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		updatepwdButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		updatepwdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatepwdActionperformed(e);
			}
		});
		securitymenu.add(updatepwdButton);
		
		JMenuItem exitButton = new JMenuItem("\u9000\u51FA");
		exitButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否要退出系统");
				if (result == 0)
					userExitActionPerformed(e);
					dispose();
			}
		});
		securitymenu.add(exitButton);
		
		JMenu aboutusmenu = new JMenu("\u5173\u4E8E\u6211\u4EEC    ");
		aboutusmenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		aboutusmenu.setIcon(new ImageIcon(Usermainfrm.class.getResource("/image/about.png")));
		menuBar.add(aboutusmenu);
		
		JMenuItem contactusmenu = new JMenuItem("\u8054\u7CFB\u6211\u4EEC");
		contactusmenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		contactusmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUsActionPerformed(e);
			}
		});
		aboutusmenu.add(contactusmenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		Table = new JDesktopPane();
		Table.setBackground(Color.GRAY);
		GroupLayout gl_Table = new GroupLayout(Table);
		gl_Table.setHorizontalGroup(
			gl_Table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1347, Short.MAX_VALUE)
		);
		gl_Table.setVerticalGroup(
			gl_Table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 579, Short.MAX_VALUE)
		);
		Table.setLayout(gl_Table);
		contentPane.add(Table);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	private void reviewActionPerformed(ActionEvent e) {
		ReviewWordView rww = new ReviewWordView(user);
		rww.setVisible(true);
		Table.add(rww);
	}

	private void userExitActionPerformed(ActionEvent e) {
		JDBCUtils.closeResource();
	}

	private void aboutUsActionPerformed(ActionEvent e) {
		AboutUs au = new AboutUs();
		Table.add(au);
	}

	private void achieveActionPerformed(ActionEvent e) {
		Myachieve achieve = new Myachieve(user.getUpage());
		achieve.setVisible(true);
		Table.add(achieve);
	}
	
	
	private void updatepwdActionperformed(ActionEvent e) {
		Uupdatepwdfrm updatepwd= new Uupdatepwdfrm(user);
		updatepwd.setVisible(true);
		Table.add(updatepwd);
	}


	private void searchActionPerformed(ActionEvent e) {
		EnZhseek search = new EnZhseek(user);
		Table.add(search);
	}


	private void mycollectActionPerformed(ActionEvent e) {
		Mysave save = new Mysave(user);
		save.setVisible(true);
		Table.add(save);
	}


	private void reciteActionPerforemd(ActionEvent e) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("请输入单词显示间隔(单位s)").trim());
		ReciteWordView rwv = new ReciteWordView(user,n);
		Table.add(rwv);
	}
}
