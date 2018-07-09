package view;

import java.awt.BorderLayout;
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

import com.mysql.jdbc.Connection;

import dao.UserDao;
import model.UserBean;
import util.CharacterUtil;
import util.JDBCUtils;

public class Userlogin extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField usernametext;
	private JPasswordField passwordtext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userlogin frame = new Userlogin();
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
	public Userlogin() {
		setResizable(false);
		setTitle("用户登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 320, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton resetBtn = new JButton("重置");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetValueActionPerformed(evt);
			}
		});
		
		JLabel TitleLabel = new JLabel("大学英语词汇学习系统");
		TitleLabel.setIcon(new ImageIcon(Userlogin.class.getResource("/image/logo.png")));
		TitleLabel.setFont(new Font("黑体", Font.BOLD, 24));
		
		JLabel nameLabel = new JLabel("\u7528\u6237\u540D");
		nameLabel.setIcon(new ImageIcon(Userlogin.class.getResource("/image/modify.png")));
		nameLabel.setFont(new Font("黑体", Font.BOLD, 14));
		
		usernametext = new JTextField();
		usernametext.setColumns(10);
		
		JButton loginBtn = new JButton("登陆");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogonActionPerformed(e);
			}
		});
		
		JLabel pwdLabel = new JLabel("密 码");
		pwdLabel.setIcon(new ImageIcon(Userlogin.class.getResource("/image/password.png")));
		pwdLabel.setFont(new Font("黑体", Font.BOLD, 14));
		
		passwordtext = new JPasswordField();
		
		JButton backBtn = new JButton("返回");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		GroupLayout grouplayout = new GroupLayout(panel);
		grouplayout.setHorizontalGroup(
			grouplayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(grouplayout.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
						.addComponent(TitleLabel)
						.addGroup(grouplayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(grouplayout.createSequentialGroup()
								.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
							.addGroup(grouplayout.createSequentialGroup()
								.addGroup(grouplayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(loginBtn)
									.addComponent(pwdLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
									.addGroup(grouplayout.createSequentialGroup()
										.addGap(18)
										.addComponent(passwordtext))
									.addGroup(grouplayout.createSequentialGroup()
										.addGap(41)
										.addComponent(resetBtn)
										.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
										.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))))))
					.addGap(42))
		);
		grouplayout.setVerticalGroup(
			grouplayout.createParallelGroup(Alignment.LEADING)
				.addGroup(grouplayout.createSequentialGroup()
					.addGap(19)
					.addComponent(TitleLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBtn)
						.addComponent(resetBtn)
						.addComponent(backBtn))
					.addGap(26))
		);
		panel.setLayout(grouplayout);
		this.setVisible(true);
	}
	/**
	 * ��¼���洦��
	 * @param e
	 */
	private void userlogonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = this.usernametext.getText();
		String password = new String(this.passwordtext.getPassword());
		if(CharacterUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(CharacterUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}

		UserBean user=null;

		try {
			user = UserDao.checkLogin(username, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(user == null) {
			JOptionPane.showMessageDialog(null,"用户名或密码错误");	
		} 
		else {
			dispose();
		//	JOptionPane.showMessageDialog(null, "��½�ɹ���");
			new Usermainfrm(user);
		}
	}
	private void backActionPerformed(ActionEvent e) {
		dispose();
		new Logonform();
	}
	private void resetValueActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		this.usernametext.setText("");
		this.passwordtext.setText("");
	}

}
