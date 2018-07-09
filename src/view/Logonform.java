package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.JDBCUtils;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logonform extends JFrame {

	private JPanel userregisterPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logonform frame = new Logonform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Logonform() {
		// 测试并获得数据库连接，作为程序启动的必要条件，添加到登录窗口的构造函数中
		try {
			Class.forName("util.JDBCUtils");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println("数据库连接"+JDBCUtils.getConnection());
		
		
		setResizable(false);
		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 320, 488, 336);
		userregisterPanel = new JPanel();
		userregisterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(userregisterPanel);
		
		JButton manageLogBtn = new JButton("管理员登陆");
		manageLogBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Managerlogin();
			}
		});
		
		JLabel titleLabel = new JLabel("大学英语词汇学习系统");
		titleLabel.setFont(new Font("宋体", Font.BOLD, 22));
		
		JButton userLogBtn = new JButton("用户登陆");
		userLogBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Userlogin();
			}
		});
		
		JButton useRegBtn = new JButton("用户注册");
		useRegBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uregisterActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(userregisterPanel);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(98)
							.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(156)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(manageLogBtn, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(useRegBtn, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(userLogBtn, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(manageLogBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(userLogBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(useRegBtn, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		userregisterPanel.setLayout(groupLayout);
		setVisible(true);
	}
	/**
	 * 用户注册
	 * @param e
	 */
	private void uregisterActionPerformed(ActionEvent e) {
		dispose();
		new Uregisterfrm();
	}
}
