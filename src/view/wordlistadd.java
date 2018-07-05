package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class wordlistadd extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordlistadd frame = new wordlistadd();
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
	public wordlistadd() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u8BCD\u6C47\u8868");
		setBounds(100, 100, 470, 321);
		
		JLabel lblNewLabel = new JLabel("\u8BCD\u6C47\u8868\u540D\u79F0\uFF1A");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BCD\u6C47\u8868\u63CF\u8FF0\uFF1A");
		
		JTextArea textArea = new JTextArea();
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.setFont(new Font("ºÚÌå", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(65, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(190))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(41))
		);
		getContentPane().setLayout(groupLayout);

	}

}
