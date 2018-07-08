package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.ManagerDao;
import dao.UserDao;
import model.UserBean;
import util.CharacterUtil;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Uupdatepwdfrm extends JInternalFrame {
	private JPasswordField pwdoldTxt;
	private JPasswordField pwdnewTxt;
	private JPasswordField pwdnewisTxt;
	private  UserBean user;

	/**
	 * Create the frame.
	 */
	public Uupdatepwdfrm(UserBean user) {
		this.user = user;
		setTitle("用户密码修改");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 593, 434);
		
		JLabel pwdoldlabel = new JLabel("原密码：");
		pwdoldlabel.setFont(new Font("黑体", Font.BOLD, 18));
		
		pwdoldTxt = new JPasswordField();
		
		JLabel pwdnewlabel = new JLabel("新密码：");
		pwdnewlabel.setFont(new Font("黑体", Font.BOLD, 18));
		
		pwdnewTxt = new JPasswordField();
		
		JLabel pwdnewislabel = new JLabel("  请确认新密码：");
		pwdnewislabel.setFont(new Font("黑体", Font.BOLD, 18));
		
		pwdnewisTxt = new JPasswordField();
		
		JButton updateButton = new JButton("确认");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatepwdActionPerformed(e);
			}
		});
		updateButton.setFont(new Font("黑体", Font.BOLD, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(pwdnewlabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(pwdnewTxt, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(pwdoldlabel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(pwdoldTxt, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(pwdnewislabel)
							.addGap(18)
							.addComponent(pwdnewisTxt, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(240)
							.addComponent(updateButton)))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdoldlabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(pwdoldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdnewlabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(pwdnewTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdnewislabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(pwdnewisTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(71)
					.addComponent(updateButton)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void updatepwdActionPerformed(ActionEvent evt) {
		String old  = new String(this.pwdoldTxt.getPassword());
		if( !old.equals(user.getUpwd())) {
			JOptionPane.showMessageDialog(null, "原密码错误");
			return ;
		}
		String newpwd = new String(this.pwdnewTxt.getPassword());
		if(CharacterUtil.isEmpty(newpwd)) {
			JOptionPane.showMessageDialog(null, "新密码不能为空");
			return ;
		}
		String repeat = new String(this.pwdnewisTxt.getPassword());
		if(!newpwd.equals(repeat)) {
			JOptionPane.showMessageDialog(null, "两次输入不一致");
			return ;
		}
		boolean isSuccess = false;
		try {
			isSuccess = UserDao.setPwd(user.getUid(), newpwd);
			if(isSuccess) {
				JOptionPane.showMessageDialog(null, "修改成功");
				return ;
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
				return ;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "修改失败");
			e1.printStackTrace();
		}
		this.dispose();
	}
}
