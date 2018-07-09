package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.dbutils.QueryRunner;

import com.mysql.jdbc.RowData;

import dao.CollectDao;
import dao.UserDao;
import dao.VocabularyDao;
import model.CollectBean;
import model.MeaningBean;
import model.UserBean;
import model.VocabularyBean;
import model.WordBean;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mysave extends JInternalFrame {
	private JTable mysavetable;
	private UserBean user;
	private CollectTableModel ctm = null;

	/**
	 * Create the frame.
	 */
	public Mysave(UserBean user) {
		this.user = user;
		setRootPaneCheckingEnabled(false);
		setEnabled(false);
		setIconifiable(true);
		setClosable(true);
		setTitle("我的收藏");
		setBounds(100, 100, 924, 580);

		JScrollPane Table = new JScrollPane();
		
		JButton deleteButton = new JButton("删除所选");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletecollectActionPerformed(e);
			}
		});
		deleteButton.setFont(new Font("黑体", Font.PLAIN, 20));
		
		JButton quitSelectBtn = new JButton("取消选择");
		quitSelectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitSelectActionPerformed(e);
			}
		});
		quitSelectBtn.setFont(new Font("黑体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(191)
					.addComponent(deleteButton)
					.addPreferredGap(ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
					.addComponent(quitSelectBtn)
					.addGap(231))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(Table, GroupLayout.PREFERRED_SIZE, 814, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(Table, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(quitSelectBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addGap(53))
		);

		mysavetable = new JTable();
		Table.setViewportView(mysavetable);
		getContentPane().setLayout(groupLayout);
		fillTableValue();
	}

	private void quitSelectActionPerformed(ActionEvent e) {
		int rowCnt = ctm.getRowCount();
		for(int i = 0;i<rowCnt;i++) {
			ctm.setValueAt(false, i, 5);;
		}
	}

	private void deletecollectActionPerformed(ActionEvent e) {
		int rowCnt = ctm.getRowCount();
		boolean noSelect = true;
		for(int i = 0;i<rowCnt;i++) {
			Boolean b = (Boolean) ctm.getValueAt(i, 5);
			int wid = (Integer) ctm.getValueAt(i, 0);
			boolean isSuccess = false;
			if(b) {
				noSelect = false;
				try {
					isSuccess = CollectDao.deleteCollectBean(user.getUid(),wid);
					if(!isSuccess) {
						JOptionPane.showMessageDialog(null, "删除失败");
						return ;
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "删除失败");
					e1.printStackTrace();
					return ;
				}
			}
		}
		if(noSelect) {
			JOptionPane.showMessageDialog(null, "请选中要删除的单词");
		} else {
			JOptionPane.showMessageDialog(null, "删除成功");
		}
		fillTableValue();
	}

	private void fillTableValue() {
		List<WordBean> query;
		try {
			query = CollectDao.queryUserCollect(user.getUid());
			if (query != null) {
				ctm = new CollectTableModel(query.size());
				for (WordBean collect : query) {
					Object[] row = new Object[6];
					row[0] = collect.getWid();
					row[1] = collect.getWord();
					StringBuffer mean = new StringBuffer("");
					for (MeaningBean mb : collect.getMeans()) {
						mean.append(mb.getChinese() + ";");
					}
					row[2] = mean.toString();
					row[3] = collect.getEg();
					row[4] = collect.getTrans();
					row[5] = new Boolean(false);
					ctm.setRowData(row);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		mysavetable.setModel(ctm);
	}
}
