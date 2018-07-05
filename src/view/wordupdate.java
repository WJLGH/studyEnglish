package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wordupdate extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordupdate frame = new wordupdate();
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
	public wordupdate() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u66F4\u65B0\u5355\u8BCD");
		setBounds(100, 100, 719, 709);
		
		JLabel lblNewLabel = new JLabel("词汇表：");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.setFont(new Font("����", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8BCD\u6C47\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(142))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u8868\u5355");
		lblNewLabel_1.setBounds(345, 93, 52, 15);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 12));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(443, 89, 63, 21);
		
		JLabel lblNewLabel_2 = new JLabel("\u5355\u8BCD\uFF1A");
		lblNewLabel_2.setBounds(16, 91, 39, 15);
		lblNewLabel_2.setFont(new Font("����", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setBounds(69, 88, 75, 32);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u91CA\u4E49\uFF1A");
		lblNewLabel_3.setBounds(16, 149, 39, 15);
		lblNewLabel_3.setFont(new Font("����", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setBounds(69, 145, 392, 23);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u4F8B\u53E5:");
		lblNewLabel_4.setBounds(16, 205, 33, 15);
		lblNewLabel_4.setFont(new Font("����", Font.BOLD, 12));
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(69, 200, 437, 20);
		panel.setLayout(null);
		panel.add(lblNewLabel_1);
		panel.add(comboBox);
		panel.add(lblNewLabel_2);
		panel.add(textField_1);
		panel.add(lblNewLabel_3);
		panel.add(textField_2);
		panel.add(lblNewLabel_4);
		panel.add(textArea);
		
		JButton btnNewButton_1 = new JButton("\u63D0\u4EA4");
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 20));
		btnNewButton_1.setBounds(106, 262, 93, 23);
		panel.add(btnNewButton_1);
		
		JLabel label = new JLabel("编号：");
		label.setBounds(16, 33, 52, 21);
		panel.add(label);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(69, 31, 86, 24);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 20));
		button_1.setBounds(413, 262, 93, 23);
		panel.add(button_1);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5355\u8BCD", "\u6240\u5C5E\u8868\u5355", "\u91CA\u4E49", "\u4F8B\u53E5"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(62);
		table.getColumnModel().getColumn(1).setPreferredWidth(66);
		table.getColumnModel().getColumn(3).setPreferredWidth(46);
		getContentPane().setLayout(groupLayout);

	}
}
