package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.MeaningDao;
import dao.VocabularyDao;
import dao.WordDao;
import model.MeaningBean;
import model.VocabularyBean;
import model.WordBean;
import util.CharacterUtil;
import util.JDBCUtils;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class wordupdate extends JInternalFrame {
	private JTable table;
	private JTextField wordTxt;
	private JTextField meaningListTxt;
	private JTextField wordwidTxt;
	private JTextField wordsearchTxt;
	private JTextField egTxt;
	private JTextField transTxt;
	JComboBox vocabularysearchListCb;
	JComboBox vocabularyCb ;
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
		setBounds(100, 100, 662, 667);
		
		JLabel vocabularyListLabel = new JLabel("词汇表：");
		vocabularyListLabel.setFont(new Font("����", Font.BOLD, 20));
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchActionPerformed(e);
			}
		});
		searchButton.setFont(new Font("����", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8BCD\u6C47\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel wordLabel = new JLabel("单词：");
		wordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		wordLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		
		wordsearchTxt = new JTextField();
		wordsearchTxt.setColumns(10);
		
		vocabularysearchListCb = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(wordLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(wordsearchTxt, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(vocabularyListLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(vocabularysearchListCb, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchButton)
							.addGap(45))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane, Alignment.LEADING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
							.addGap(16))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchButton)
						.addComponent(wordLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(vocabularyListLabel)
						.addComponent(wordsearchTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(vocabularysearchListCb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		JLabel uwordvaLabel = new JLabel("\u6240\u5C5E\u8868\u5355");
		uwordvaLabel.setBounds(352, 89, 52, 21);
		uwordvaLabel.setFont(new Font("黑体", Font.PLAIN, 12));
		
		vocabularyCb = new JComboBox();
		vocabularyCb.setBounds(414, 89, 125, 21);
		
		JLabel uwordLabel = new JLabel("\u5355\u8BCD\uFF1A");
		uwordLabel.setBounds(16, 91, 39, 17);
		uwordLabel.setFont(new Font("黑体", Font.PLAIN, 12));
		
		wordTxt = new JTextField();
		wordTxt.setEditable(false);
		wordTxt.setBounds(65, 88, 75, 23);
		wordTxt.setColumns(10);
		
		JLabel meaningLabel = new JLabel("\u91CA\u4E49\uFF1A");
		meaningLabel.setBounds(16, 149, 39, 15);
		meaningLabel.setFont(new Font("黑体", Font.PLAIN, 12));
		
		meaningListTxt = new JTextField();
		meaningListTxt.setBounds(65, 145, 160, 23);
		meaningListTxt.setColumns(10);
		
		JLabel transLabel = new JLabel("译：");
		transLabel.setBounds(16, 231, 39, 21);
		transLabel.setFont(new Font("黑体", Font.PLAIN, 12));
		panel.setLayout(null);
		panel.add(uwordvaLabel);
		panel.add(vocabularyCb);
		panel.add(uwordLabel);
		panel.add(wordTxt);
		panel.add(meaningLabel);
		panel.add(meaningListTxt);
		panel.add(transLabel);
		
		JButton updateButton = new JButton("修改");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		updateButton.setFont(new Font("����", Font.BOLD, 20));
		updateButton.setBounds(116, 284, 93, 32);
		panel.add(updateButton);
		
		JLabel wordwidLabel = new JLabel("编号：");
		wordwidLabel.setBounds(16, 33, 52, 21);
		panel.add(wordwidLabel);
		
		wordwidTxt = new JTextField();
		wordwidTxt.setEditable(false);
		wordwidTxt.setBounds(66, 32, 86, 24);
		panel.add(wordwidTxt);
		wordwidTxt.setColumns(10);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteActionPerformed(e);
			}
		});
		deleteButton.setFont(new Font("Dialog", Font.BOLD, 20));
		deleteButton.setBounds(379, 284, 93, 32);
		panel.add(deleteButton);
		
		JLabel egLabel = new JLabel("例句:");
		egLabel.setFont(new Font("黑体", Font.PLAIN, 12));
		egLabel.setBounds(16, 189, 39, 21);
		panel.add(egLabel);
		
		egTxt = new JTextField();
		egTxt.setBounds(65, 189, 474, 21);
		panel.add(egTxt);
		egTxt.setColumns(10);
		
		transTxt = new JTextField();
		transTxt.setBounds(65, 231, 474, 21);
		panel.add(transTxt);
		transTxt.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectRowMousePressed(e);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5355\u8BCD", "\u6240\u5C5E\u8868\u5355", "\u91CA\u4E49", "\u4F8B\u53E5", "\u8BD1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(62);
		table.getColumnModel().getColumn(1).setPreferredWidth(66);
		table.getColumnModel().getColumn(3).setPreferredWidth(46);
		getContentPane().setLayout(groupLayout);
		fillSearchJc();
	}
	private void deleteActionPerformed(ActionEvent e) {
		if(CharacterUtil.isEmpty(this.wordwidTxt.getText())) {
			JOptionPane.showMessageDialog(null, "请选择要删除的单词");
			return;
		}
		int wid = Integer.parseInt(this.wordwidTxt.getText());
		boolean isSuccess = false;
		try {
			isSuccess = WordDao.deleteWordBean(wid);
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
	}

	private void updateActionPerformed(ActionEvent e) {
		if(CharacterUtil.isEmpty(this.wordwidTxt.getText())) {
			JOptionPane.showMessageDialog(null, "请选择要修改的单词");
			return;
		}
		int wid = Integer.parseInt(this.wordwidTxt.getText());
		String word = this.wordTxt.getText();
		String eg = this.egTxt.getText();
		String trans = this.transTxt.getText();
		VocabularyBean vb = (VocabularyBean) this.vocabularyCb.getSelectedItem();
		int vid = vb.getVid();
		String meangingList = meaningListTxt.getText();
		if(CharacterUtil.isEmpty(meangingList) ) {
			JOptionPane.showMessageDialog(null, "意思不能为空");
			return ;
		}
		if(CharacterUtil.isEmpty(eg) ) {
			JOptionPane.showMessageDialog(null, "例句不能为空");
			return ;
		}
		if(CharacterUtil.isEmpty(trans) ) {
			JOptionPane.showMessageDialog(null, "翻译不能为空");
			return ;
		}
		if(CharacterUtil.isEmpty(meangingList) ) {
			JOptionPane.showMessageDialog(null, "意思不能为空");
			return ;
		}
		WordBean wordBean = new WordBean(wid,word, eg, trans, vid);
		boolean isSuccess = false;
		try {
			System.out.println("vid:"+vid);
			isSuccess = WordDao.updateWordBean(wordBean);
			if(!isSuccess) {
				throw new SQLException();
			}
			MeaningDao.deleteWordMeaing(wid);
			String[] ma = CharacterUtil.meaningStrToArray(meangingList);
			for(String chinese: ma) {
				MeaningBean mb = new MeaningBean(chinese,wid);
				isSuccess = MeaningDao.addMeaningBean(mb);
				if(!isSuccess) {
					throw new SQLException();
				}
			}
			JOptionPane.showMessageDialog(null, "修改成功");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "修改失败");
			e1.printStackTrace();
		}
		resetFormValue();
	}

	private void selectRowMousePressed(MouseEvent e) {
		int selectedRow = this.table.getSelectedRow();
		this.wordwidTxt.setText(table.getValueAt(selectedRow,0)+"");
		this.wordTxt.setText(table.getValueAt(selectedRow, 1)+"");
		this.vocabularyCb.setSelectedItem(table.getValueAt(selectedRow, 2));
		this.meaningListTxt.setText(table.getValueAt(selectedRow, 3)+"");
		this.egTxt.setText(table.getValueAt(selectedRow, 4)+"");
		this.transTxt.setText(table.getValueAt(selectedRow, 5)+"");
	}
	
	private void resetFormValue() {
		this.wordwidTxt.setText("");
		this.wordTxt.setText("");
		this.egTxt.setText("");
		this.transTxt.setText("");
		this.meaningListTxt.setText("");
	}
	
	
	private void fillSearchJc() {
		List<VocabularyBean> query = null;
		this.vocabularysearchListCb.addItem(new VocabularyBean(-1, "请选择", ""));
		try {
			query = VocabularyDao.query();
			for (VocabularyBean vocabularyBean : query) {
				this.vocabularyCb.addItem(vocabularyBean);
				this.vocabularysearchListCb.addItem(vocabularyBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void searchActionPerformed(ActionEvent e) {
		String word = this.wordsearchTxt.getText();
		VocabularyBean vb = (VocabularyBean) this.vocabularysearchListCb.getSelectedItem();
		int vid = vb.getVid();
		if(CharacterUtil.isEmpty(word) && vid == -1) {
			JOptionPane.showMessageDialog(null, "请指定查询条件");
			return ;
		}
		List<WordBean> searchList = null;
		try {
			searchList = WordDao.querySearch(word,vid);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(null != searchList) {
			DefaultTableModel model = (DefaultTableModel) this.table.getModel();
			model.setRowCount(0);
			for (WordBean wordBean : searchList) {
				Vector row = new Vector();
				row.add(wordBean.getWid());
				
				row.add(wordBean.getWord());
				
				VocabularyBean voc = VocabularyDao.queryByVid(wordBean.getVid());
				row.add(voc);
				StringBuffer mean = new StringBuffer("");
				for(MeaningBean mb :wordBean.getMeans()) {
					mean.append(mb.getChinese()+";");
				}
				row.add(mean.toString());
				row.add(wordBean.getEg());
				row.add(wordBean.getTrans());
				model.addRow(row);
			}
		}
	}
}
