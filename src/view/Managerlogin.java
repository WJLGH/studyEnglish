package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import dao.ManagerDao;
import model.ManagerBean;
import util.CharacterUtil;
import util.stringutil;

public class Managerlogin extends JFrame {

	private JPanel contentPane;
	private JTextField usernametext;
	private JPasswordField passwordtext;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Managerlogin frame = new Managerlogin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Managerlogin() {
		setResizable(false);
		setTitle("管理员登陆");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 320, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel titleLabel = new JLabel("大学英语词汇学习系统");
		titleLabel.setIcon(new ImageIcon(Managerlogin.class.getResource("/image/logo.png")));
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		
		JLabel usernameLabel = new JLabel("管理员名");
		usernameLabel.setIcon(new ImageIcon(Managerlogin.class.getResource("/image/modify.png")));
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel pwdlabel = new JLabel("密  码");
		pwdlabel.setIcon(new ImageIcon(Managerlogin.class.getResource("/image/password.png")));
		pwdlabel.setFont(new Font("黑体", Font.BOLD, 14));
		
		usernametext = new JTextField();
		usernametext.setColumns(10);
		
		passwordtext = new JPasswordField();
		
		JButton logonButton = new JButton("登陆");
		logonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		
		JButton backBtn = new JButton("返回");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		GroupLayout grouplayout = new GroupLayout(contentPane);
		grouplayout.setHorizontalGroup(
			grouplayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(grouplayout.createSequentialGroup()
					.addContainerGap(74, Short.MAX_VALUE)
					.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
						.addComponent(titleLabel)
						.addGroup(grouplayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(grouplayout.createSequentialGroup()
								.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
							.addGroup(grouplayout.createSequentialGroup()
								.addGroup(grouplayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(logonButton)
									.addComponent(pwdlabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
									.addGroup(grouplayout.createSequentialGroup()
										.addGap(18)
										.addComponent(passwordtext))
									.addGroup(grouplayout.createSequentialGroup()
										.addGap(46)
										.addComponent(resetButton)
										.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
										.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))))))
					.addGap(42))
		);
		grouplayout.setVerticalGroup(
			grouplayout.createParallelGroup(Alignment.LEADING)
				.addGroup(grouplayout.createSequentialGroup()
					.addGap(19)
					.addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdlabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(logonButton)
						.addComponent(resetButton)
						.addComponent(backBtn))
					.addGap(26))
		);
		contentPane.setLayout(grouplayout);
		this.setVisible(true);
	}

	private void backActionPerformed(ActionEvent e) {
		dispose();
		new Logonform();
	}

	private void loginActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = this.usernametext.getText();
		String password = new String(this.passwordtext.getPassword());
		if(CharacterUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "管理员名不能为空");
			return;
		}
		if(CharacterUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		
		ManagerBean manager = null;
		try {
			manager = ManagerDao.checkLogin(userName, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(manager == null) {
			JOptionPane.showMessageDialog(null, "管理员名或密码错误");
		}
		else {
			this.dispose();
			new Managermainfrm(manager);
		}
	}

	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.usernametext.setText("");
		this.passwordtext.setText("");
		
	}
}
