package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class EnZhseek extends JInternalFrame {
	private JTextField Enword;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnZhseek frame = new EnZhseek();
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
	public EnZhseek() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u82F1\u8BD1\u6C49");
		setBounds(100, 100, 490, 383);
		
		JLabel label = new JLabel("");
		
		JLabel lblNewLabel = new JLabel("单词：");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		
		Enword = new JTextField();
		Enword.setColumns(10);
		
		JLabel label_1 = new JLabel("\u91CA\u4E49\uFF1A");
		label_1.setFont(new Font("����", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("\u4F8B\u53E5\uFF1A");
		label_2.setFont(new Font("����", Font.BOLD, 20));
		
		JTextArea sentence = new JTextArea();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 17));
		
		JButton btnNewButton_1 = new JButton("网络搜索");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(39, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel)
									.addComponent(label_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(30))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnNewButton_1)
								.addPreferredGap(ComponentPlacement.RELATED))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField, Alignment.LEADING)
								.addComponent(Enword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
							.addGap(43)
							.addComponent(btnNewButton))
						.addComponent(sentence, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))
					.addGap(37))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(label)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(Enword, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(sentence, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(58))
		);
		getContentPane().setLayout(groupLayout);

	}
}
