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
		try {
			Class.forName("util.JDBCUtils");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		setResizable(false);
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 320, 488, 336);
		userregisterPanel = new JPanel();
		userregisterPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(userregisterPanel);
		
		JButton btnNewButton = new JButton("\u7BA1\u7406\u5458\u767B\u9646");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Managerlogin();
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u5927\u5B66\u82F1\u8BED\u8BCD\u6C47\u5B66\u4E60\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 22));
		
		JButton button = new JButton("\u7528\u6237\u767B\u9646");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Userlogin();
			}
		});
		
		JButton button_1 = new JButton("用户注册");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uregisterActionPerformed(e);
			}
		});
		GroupLayout gl_userregisterPanel = new GroupLayout(userregisterPanel);
		gl_userregisterPanel.setHorizontalGroup(
			gl_userregisterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userregisterPanel.createSequentialGroup()
					.addGroup(gl_userregisterPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_userregisterPanel.createSequentialGroup()
							.addGap(98)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_userregisterPanel.createSequentialGroup()
							.addGap(156)
							.addGroup(gl_userregisterPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_userregisterPanel.setVerticalGroup(
			gl_userregisterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_userregisterPanel.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		userregisterPanel.setLayout(gl_userregisterPanel);
		setVisible(true);
	}

	private void uregisterActionPerformed(ActionEvent e) {
		dispose();
		new Uregisterfrm();
	}
}
