package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class myachieve extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myachieve frame = new myachieve();
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
	public myachieve() {
		setTitle("\u6211\u7684\u6210\u5C31");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 525, 384);
		
		JLabel lblNewLabel = new JLabel("\u80CC\u8BF5\u5355\u8BCD\u4E2A\u6570\uFF1A");
		lblNewLabel.setFont(new Font("ºÚÌå", Font.BOLD, 24));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("ºÚÌå", Font.BOLD, 23));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(48)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(168, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
