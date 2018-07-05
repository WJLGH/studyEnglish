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
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class wordlistpdate extends JInternalFrame {
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordlistpdate frame = new wordlistpdate();
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
	public wordlistpdate() {
		setIconifiable(true);
		setClosable(true);
		setTitle("\u8BCD\u6C47\u8868\u7EF4\u62A4");
		setBounds(100, 100, 540, 380);
		
		JLabel lblNewLabel = new JLabel("\u8BCD\u6C47\u8868\u540D\u79F0\uFF1A");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("\u8BCD\u6C47\u8868\u540D\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("黑体", Font.BOLD, 15));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u63CF\u8FF0\uFF1A");
		lblNewLabel_3.setFont(new Font("黑体", Font.BOLD, 15));
		
		JTextArea textArea = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.setFont(new Font("黑体", Font.BOLD, 15));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setFont(new Font("黑体", Font.BOLD, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(38)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(18)
							.addComponent(textArea)))
					.addContainerGap(24, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(103)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(119))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u8BCD\u6C47\u8868\u540D\u79F0", "\u8BCD\u6C47\u8868\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(111);
		table.getColumnModel().getColumn(2).setPreferredWidth(135);
		getContentPane().setLayout(groupLayout);

	}
}
