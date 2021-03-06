package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.UserDao;
import model.UserBean;
import util.CharacterUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;

public class Uregisterfrm extends JFrame {
	private JTextField userNameTxt;
	private JTextField userPwdTxt;

	/**
	 * Create the frame.
	 */
	public Uregisterfrm() {
		setTitle("用户注册");
		setBounds(600,320, 525, 428);
		
		JLabel lblNewLabel = new JLabel("欢迎注册本系统");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 30));
		
		JButton registeButton = new JButton("立即注册");
		registeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registeActionPerformed(e);
			}
		});
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		userPwdTxt = new JTextField();
		userPwdTxt.setColumns(10);
		
		JLabel nameHeadLabel = new JLabel("用户名：");
		nameHeadLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel pwdHeadLabel = new JLabel("密码：");
		pwdHeadLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton backBtn = new JButton("返回");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(nameHeadLabel)
						.addComponent(pwdHeadLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(registeButton)
							.addGap(68)
							.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel)
							.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
							.addComponent(userPwdTxt, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
					.addGap(111))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(84)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameHeadLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pwdHeadLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(userPwdTxt, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(registeButton)
						.addComponent(backBtn))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}

	private void backActionPerformed(ActionEvent e) {
		dispose();
		new Logonform();
	}

	private void registeActionPerformed(ActionEvent e) {
		String uname = userNameTxt.getText();
		String upwd = userPwdTxt.getText();
		boolean isAvai = false;
		boolean isSuccess = false;
		if(CharacterUtil.isEmpty(uname)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(CharacterUtil.isEmpty(upwd)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		try {
			isAvai = UserDao.userNameAvailable(uname);
			if(!isAvai) {
				JOptionPane.showMessageDialog(null, "用户名已注册");
				return ;
			}
			isSuccess = UserDao.addUser(new UserBean(uname, upwd));
			if(isSuccess) {
				JOptionPane.showMessageDialog(null, "注册成功");
				this.dispose();
				new Logonform();
				return ;
			} else {
				JOptionPane.showMessageDialog(null, "注册失败");
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "注册失败");
			e1.printStackTrace();
		}
	}
}
