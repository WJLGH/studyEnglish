package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dao.MeaningDao;
import dao.VocabularyDao;
import dao.WordDao;
import model.MeaningBean;
import model.VocabularyBean;
import model.WordBean;
import util.CharacterUtil;
import util.JDBCUtils;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Wordadd extends JInternalFrame {
	private JTextField wordTxt;
	private JTextField meaningListTxt;
	private JTextField egTxt;
	private JTextField transTxt;
	private JComboBox vocabularyListCb;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Wordadd frame = new Wordadd();
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
	public Wordadd() {
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("录入单词");
		setBounds(100, 100, 754, 474);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "单词信息", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		
		JLabel wordLabel = new JLabel("单词:");
		wordLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		
		wordTxt = new JTextField();
		wordTxt.setColumns(10);
		
		JLabel meaningListLabel = new JLabel("汉语意思:");
		meaningListLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		
		meaningListTxt = new JTextField();
		meaningListTxt.setColumns(10);
		
		JLabel tip = new JLabel("如果有多个，用分号隔开");
		tip.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JLabel egLabel = new JLabel("释义:");
		egLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		
		egTxt = new JTextField();
		egTxt.setColumns(10);
		
		JLabel transLabel = new JLabel("例句翻译:");
		transLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		
		transTxt = new JTextField();
		transTxt.setColumns(10);
		
		JLabel vidLabel = new JLabel("词汇表：");
		vidLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		
		vocabularyListCb = new JComboBox();
		
		JButton addButton = new JButton("添加");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWordActionPerformed(e);
			}
		});
		addButton.setFont(new Font("Dialog", Font.BOLD, 23));
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFormActionPerformed(e);
			}
		});
		resetButton.setFont(new Font("Dialog", Font.BOLD, 23));
		GroupLayout grouplayout = new GroupLayout(panel);
		grouplayout.setHorizontalGroup(
			grouplayout.createParallelGroup(Alignment.LEADING)
				.addGroup(grouplayout.createSequentialGroup()
					.addGap(29)
					.addGroup(grouplayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(grouplayout.createSequentialGroup()
							.addComponent(wordLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(wordTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(grouplayout.createSequentialGroup()
							.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
								.addComponent(meaningListLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(egLabel)
								.addComponent(transLabel)
								.addComponent(vidLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
								.addGroup(grouplayout.createSequentialGroup()
									.addComponent(vocabularyListCb, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addGap(96)
									.addComponent(resetButton)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(addButton))
								.addGroup(grouplayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, grouplayout.createSequentialGroup()
										.addComponent(meaningListTxt, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(tip, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
									.addComponent(egTxt, Alignment.LEADING)
									.addComponent(transTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)))))
					.addGap(41))
		);
		grouplayout.setVerticalGroup(
			grouplayout.createParallelGroup(Alignment.LEADING)
				.addGroup(grouplayout.createSequentialGroup()
					.addGap(25)
					.addGroup(grouplayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(grouplayout.createSequentialGroup()
							.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(wordLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(wordTxt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(meaningListLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(meaningListTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
						.addComponent(tip, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
						.addComponent(egLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(egTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
						.addComponent(transTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(transLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
						.addGroup(grouplayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(grouplayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(vidLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(vocabularyListCb, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
							.addGap(30))
						.addGroup(grouplayout.createSequentialGroup()
							.addGap(29)
							.addGroup(grouplayout.createParallelGroup(Alignment.LEADING)
								.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGap(32))))
		);
		panel.setLayout(grouplayout);
		getContentPane().setLayout(groupLayout);
		fillvocabularyListCb();
	}
	private void addWordActionPerformed(ActionEvent e) {
		String word = wordTxt.getText();
		String eg = egTxt.getText();
		String trans = transTxt.getText();
		String meangingList = meaningListTxt.getText();
		VocabularyBean vb = (VocabularyBean) vocabularyListCb.getSelectedItem();
		int vid = vb.getVid();
		if(CharacterUtil.isEmpty(word) ) {
			JOptionPane.showMessageDialog(null, "单词不能为空");
			return ;
		}
		if(!CharacterUtil.isWord(word) ) {
			JOptionPane.showMessageDialog(null, "请输入正确的单词");
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
		System.out.println("添加的单词trans"+trans);
		WordBean wordBean = new WordBean(word, eg, trans, vid);
		boolean isSuccess = false;
		try {
			isSuccess = WordDao.addWordBean(wordBean);
			if(!isSuccess) {
				throw new SQLException();
			}
			Integer wid = WordDao.queryWordBean(wordBean);
			if(wid == null) {
				throw new SQLException();
			}
			System.out.println(wid);
			String[] ma = CharacterUtil.meaningStrToArray(meangingList);
			for(String chinese: ma) {
				MeaningBean mb = new MeaningBean(chinese,wid);
				isSuccess = MeaningDao.addMeaningBean(mb);
				if(!isSuccess) {
					throw new SQLException();
				}
			}
			JOptionPane.showMessageDialog(null, "添加成功");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "添加失败");
			e1.printStackTrace();
		}
		
	}

	private void resetFormActionPerformed(ActionEvent e) {
		wordTxt.setText("");
		meaningListTxt.setText("");
		egTxt.setText("");
		transTxt.setText("");
	}

	private void fillvocabularyListCb() {
		List<VocabularyBean> query = null;
		try {
			query = VocabularyDao.query();
			for (VocabularyBean vocabularyBean : query) {
				this.vocabularyListCb.addItem(vocabularyBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
