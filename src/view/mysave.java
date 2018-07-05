package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class mysave extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mysave frame = new mysave();
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
	public mysave() {
		setRootPaneCheckingEnabled(false);
		setEnabled(false);
		setIconifiable(true);
		setClosable(true);
		setTitle("我的收藏");
		setBounds(100, 100, 526, 374);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("查看");
		btnNewButton.setFont(new Font("黑体", Font.BOLD, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(205)
					.addComponent(btnNewButton))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5355\u8BCD", "\u91CA\u4E49", "\u4F8B\u53E5", "\u4F8B\u53E5\u7FFB\u8BD1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}
}
