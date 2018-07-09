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
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 320, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton resetBtn = new JButton("\u91CD\u7F6E");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetValueActionPerformed(evt);
			}
		});
		
		JLabel TitleLabel = new JLabel("\u5927\u5B66\u82F1\u8BED\u8BCD\u6C47\u5B66\u4E60\u7CFB\u7EDF");
		TitleLabel.setIcon(new ImageIcon(Userlogin.class.getResource("/image/logo.png")));
		TitleLabel.setFont(new Font("����", Font.BOLD, 24));
		
		JLabel nameLabel = new JLabel("\u7528\u6237\u540D");
		nameLabel.setIcon(new ImageIcon(Userlogin.class.getResource("/image/modify.png")));
		nameLabel.setFont(new Font("����", Font.BOLD, 14));
		
		usernametext = new JTextField();
		usernametext.setColumns(10);
		
		JButton loginBtn = new JButton("\u767B\u9646");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userlogonActionPerformed(e);
			}
		});
		
		JLabel pwdLabel = new JLabel("\u5BC6  \u7801");
		pwdLabel.setIcon(new ImageIcon(Userlogin.class.getResource("/image/password.png")));
		pwdLabel.setFont(new Font("����", Font.BOLD, 14));
		
		passwordtext = new JPasswordField();
		
		JButton backBtn = new JButton("返回");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(TitleLabel)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addComponent(loginBtn)
									.addComponent(pwdLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(18)
										.addComponent(passwordtext))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(41)
										.addComponent(resetBtn)
										.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
										.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))))))
					.addGap(42))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(TitleLabel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernametext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBtn)
						.addComponent(resetBtn)
						.addComponent(backBtn))
					.addGap(26))
		);
		panel.setLayout(gl_panel);
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
