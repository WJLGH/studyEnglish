package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.VocabularyDao;
import model.VocabularyBean;
import util.CharacterUtil;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wordlistupdate extends JInternalFrame {
	private JTable vocabularyListTable;
	private JTextField vnameTxt;
	private JTextField vidTxt;
	private JTextArea vdescArea;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Wordlistupdate frame = new Wordlistupdate();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Wordlistupdate() {
		setIconifiable(true);
		setClosable(true);
		setTitle("词汇表维护");
		setBounds(100, 100, 592, 429);
		
		JScrollPane vocabularyListJp = new JScrollPane();
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(vocabularyListJp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(vocabularyListJp, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		JLabel vidLabel = new JLabel("编号:");
		vidLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel vnameLabel = new JLabel("词汇表名称:");
		vnameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		
		vnameTxt = new JTextField();
		vnameTxt.setColumns(10);
		
		JLabel vdescLabel = new JLabel("描述:");
		vdescLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		
		vdescArea = new JTextArea();
		
		JButton updateButton = new JButton("修改");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVocabularyActionPerformed(e);
			}
		});
		updateButton.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JButton deletButton = new JButton("删除");
		deletButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteVocabularyActionPerformed(e);
			}
		});
		deletButton.setFont(new Font("Dialog", Font.BOLD, 15));
		
		vidTxt = new JTextField();
		vidTxt.setEditable(false);
		vidTxt.setColumns(10);
		GroupLayout undergrouplayout = new GroupLayout(panel);
		undergrouplayout.setHorizontalGroup(
			undergrouplayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(undergrouplayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(undergrouplayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(undergrouplayout.createSequentialGroup()
							.addComponent(vidLabel)
							.addGap(18)
							.addComponent(vidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(vnameLabel)
							.addGap(18)
							.addComponent(vnameTxt, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(undergrouplayout.createSequentialGroup()
							.addComponent(vdescLabel)
							.addGap(18)
							.addComponent(vdescArea)))
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(undergrouplayout.createSequentialGroup()
					.addGap(103)
					.addComponent(updateButton)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addComponent(deletButton)
					.addGap(119))
		);
		undergrouplayout.setVerticalGroup(
			undergrouplayout.createParallelGroup(Alignment.LEADING)
				.addGroup(undergrouplayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(undergrouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(vidLabel)
						.addComponent(vnameLabel)
						.addComponent(vnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(vidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(undergrouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(vdescLabel)
						.addComponent(vdescArea, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(undergrouplayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(deletButton)
						.addComponent(updateButton))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel.setLayout(undergrouplayout);
		
		vocabularyListTable = new JTable();
		vocabularyListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rowSelectMouserPressed(e);
			}
		});
		vocabularyListJp.setViewportView(vocabularyListTable);
		vocabularyListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"编号", "词汇表名称", "词汇表描述"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		vocabularyListTable.getColumnModel().getColumn(1).setPreferredWidth(111);
		vocabularyListTable.getColumnModel().getColumn(2).setPreferredWidth(135);
		getContentPane().setLayout(groupLayout);
		resetFormValue();
		fillTableValue();
	}
	//删除所选单词表
	private void deleteVocabularyActionPerformed(ActionEvent e) {
		if(CharacterUtil.isEmpty(vidTxt.getText()) ) {
			JOptionPane.showMessageDialog(null, "请选择要删除的词汇表");
			return ;
		}
		int vid = Integer.parseInt(vidTxt.getText());
		boolean isSuccess = false;
		
		try {
			isSuccess = VocabularyDao.deleteVocabularyBean(vid);
			if(isSuccess) {
				JOptionPane.showMessageDialog(null, "删除成功");
			} else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "删除失败");
			e1.printStackTrace();
		}
		resetFormValue();
		fillTableValue();
	}
	//修改所选单词表
	private void updateVocabularyActionPerformed(ActionEvent e) {
		if(CharacterUtil.isEmpty(vidTxt.getText())) {
			JOptionPane.showMessageDialog(null, "请选择要修改的词汇表");
			return ;
		}
		int vid = Integer.parseInt(vidTxt.getText());
		String vname = vnameTxt.getText();
		String vdesc = vdescArea.getText();
		if(CharacterUtil.isEmpty(vname)) {
			JOptionPane.showMessageDialog(null, "词汇表名不能为空");
			return;
		}
		
		if(CharacterUtil.isEmpty(vdesc)) {
			JOptionPane.showMessageDialog(null, "描述不能为空");
			return ;
		}
		
		VocabularyBean v = new VocabularyBean(vid,vname,vdesc);
		boolean isSuccess = false;
		try {
			isSuccess = VocabularyDao.updataVocabularyBeanName(v);
			if(isSuccess) {
				JOptionPane.showMessageDialog(null, "修改成功");
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "修改失败");
			e1.printStackTrace();
		}
		resetFormValue();
		fillTableValue();
	}
	//把选中的单词表设置到表单中
	private void rowSelectMouserPressed(MouseEvent e) {
		int selectedRow = vocabularyListTable.getSelectedRow();
		this.vidTxt.setText(vocabularyListTable.getValueAt(selectedRow, 0)+"");
		this.vnameTxt.setText(vocabularyListTable.getValueAt(selectedRow, 1)+"");
		this.vdescArea.setText(vocabularyListTable.getValueAt(selectedRow, 2)+"");
	}
	//表单框中的 数据清空
	private void resetFormValue() {
		this.vidTxt.setText("");
		this.vnameTxt.setText("");
		this.vdescArea.setText("");
	}
	//把所有的单词表显示到表格中
	private void fillTableValue() {
		
		DefaultTableModel model = (DefaultTableModel) vocabularyListTable.getModel();
		model.setRowCount(0);
		List<VocabularyBean> query ;
		try {
			query = VocabularyDao.query();
			if(query  !=null) {
				for (VocabularyBean vocabularyBean : query) {
					Vector v = new Vector();
					v.add(vocabularyBean.getVid());
					v.add(vocabularyBean.getVname());
					v.add(vocabularyBean.getVdesc());
					model.addRow(v);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
