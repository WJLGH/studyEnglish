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
import java.awt.print.PrinterException;
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
		
		JButton printButton = new JButton("打印报表");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printActionPerformed(e);
			}
		});
		printButton.setFont(new Font("黑体", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addComponent(Table, GroupLayout.PREFERRED_SIZE, 814, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(deleteButton)
							.addGap(132)
							.addComponent(quitSelectBtn)
							.addGap(135)
							.addComponent(printButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(Table, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(quitSelectBtn, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(printButton, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addGap(53))
		);

		mysavetable = new JTable();
		Table.setViewportView(mysavetable);
		getContentPane().setLayout(groupLayout);
		fillTableValue();
	}
	private void printActionPerformed(ActionEvent e) {
		try {
			mysavetable.print();
		} catch (PrinterException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * 取消选中
	 * @param e
	 */
	private void quitSelectActionPerformed(ActionEvent e) {
		int rowCnt = ctm.getRowCount();
		for(int i = 0;i<rowCnt;i++) {
			ctm.setValueAt(false, i, 5);;
		}
	}
	/**
	 * 删除所选
	 * @param e
	 */
	private void deletecollectActionPerformed(ActionEvent e) {
		int rowCnt = ctm.getRowCount();
		boolean noSelect = true;//没有选中的标记变量
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
	
	/**
	 * 填充显示的用户所收藏的单词的表格
	 */
	private void fillTableValue() {
		List<WordBean> query;
		try {
			//查询当前用户的所收藏单词表
			query = CollectDao.queryUserCollect(user.getUid());
			if (query != null) {
				//新建一个model对象来装入所查询到的单词
				ctm = new CollectTableModel(query.size());
				//单词表装入model中
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
