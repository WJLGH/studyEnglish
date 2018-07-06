package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import util.CharacterUtil;

public class mupdatepwdfrm extends JInternalFrame {
	private JPasswordField pwdoldTxt;
	private JPasswordField pwdnewTxt;
	private JPasswordField pwdnewisTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mupdatepwdfrm frame = new mupdatepwdfrm();
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
	public mupdatepwdfrm() {
		setTitle("管理员密码修改");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 647, 447);
		
		JLabel pwdoldlabel = new JLabel("原密码：");
		pwdoldlabel.setFont(new Font("黑体", Font.BOLD, 20));
		
		pwdoldTxt = new JPasswordField();
		
		JLabel pwdnewlabel = new JLabel("新密码：");
		pwdnewlabel.setFont(new Font("黑体", Font.BOLD, 20));
		
		pwdnewTxt = new JPasswordField();
		
		JLabel pwdnewislabel = new JLabel("请确认新密码：");
		pwdnewislabel.setFont(new Font("黑体", Font.BOLD, 20));
		
		pwdnewisTxt = new JPasswordField();
		
		JButton updateButton = new JButton("确定");
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
							.addGap(103)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(pwdoldlabel)
									.addGap(18)
									.addComponent(pwdoldTxt, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(pwdnewlabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(pwdnewTxt, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(pwdnewislabel)
							.addGap(18)
							.addComponent(pwdnewisTxt, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(238)
							.addComponent(updateButton)))
					.addContainerGap(215, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdoldlabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(pwdoldTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pwdnewTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pwdnewlabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(pwdnewislabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(pwdnewisTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(updateButton)
					.addGap(63))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void updatepwdActionPerformed(ActionEvent e) {
		System.out.println("mima"+new String(pwdoldTxt.getPassword()));
	}
}
