package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.WordDao;
import model.UserBean;
import util.CharacterUtil;
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
	private JDesktopPane Table = null;
	private UserBean user;

	/**
	 * Create the frame.
	 */
	public Usermainfrm(UserBean user) {
		this.user = user;
		setTitle("用户主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1082, 765);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mydictionarymenu = new JMenu("我的词典       ");
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
		
		JMenu securitymenu = new JMenu("系统安全        ");
		securitymenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		securitymenu.setIcon(new ImageIcon(Usermainfrm.class.getResource("/image/base.png")));
		menuBar.add(securitymenu);
		
		JMenuItem updatepwdButton = new JMenuItem("修改密码");
		updatepwdButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		updatepwdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatepwdActionperformed(e);
			}
		});
		securitymenu.add(updatepwdButton);
		
		JMenuItem exitButton = new JMenuItem("安全退出");
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
		
		JMenu aboutusmenu = new JMenu("关于我们    ");
		aboutusmenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 22));
		aboutusmenu.setIcon(new ImageIcon(Usermainfrm.class.getResource("/image/about.png")));
		menuBar.add(aboutusmenu);
		
		JMenuItem contactusmenu = new JMenuItem("联系我们");
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
		GroupLayout grouplayout = new GroupLayout(Table);
		grouplayout.setHorizontalGroup(
			grouplayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1347, Short.MAX_VALUE)
		);
		grouplayout.setVerticalGroup(
			grouplayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 579, Short.MAX_VALUE)
		);
		Table.setLayout(grouplayout);
		contentPane.add(Table);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
	}
	
	private void reviewActionPerformed(ActionEvent e) {
		if(user.getUpage()<WordDao.pageSize) {
			JOptionPane.showMessageDialog(null, "请先背诵单词");
			return ;
		} 
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
		TranslateView search = new TranslateView(user);
		Table.add(search);
	}


	private void mycollectActionPerformed(ActionEvent e) {
		Mysave save = new Mysave(user);
		save.setVisible(true);
		Table.add(save);
	}


	private void reciteActionPerforemd(ActionEvent e) {
		String num = JOptionPane.showInputDialog("请输入单词显示间隔(单位s)").trim();
		if(CharacterUtil.isEmpty(num)) {
			JOptionPane.showMessageDialog(null, "请输入间隔");
			return ;
		}
		if( !CharacterUtil.isNumber(num)) {
			JOptionPane.showMessageDialog(null, "请输入数字");
			return ;
		}
		int n = Integer.parseInt(num);
		ReciteWordView rwv = new ReciteWordView(user,n);
		Table.add(rwv);
	}
}
