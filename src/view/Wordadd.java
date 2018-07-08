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
	JComboBox vocabularyListCb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wordadd frame = new Wordadd();
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
	public Wordadd() {
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("\u5F55\u5165\u5355\u8BCD");
		setBounds(100, 100, 754, 474);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5355\u8BCD\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		JLabel wordLabel = new JLabel("\u5355\u8BCD\uFF1A");
		wordLabel.setFont(new Font("����", Font.BOLD, 16));
		
		wordTxt = new JTextField();
		wordTxt.setColumns(10);
		
		JLabel meaningListLabel = new JLabel("\u6C49\u8BED\u610F\u601D\uFF1A");
		meaningListLabel.setFont(new Font("����", Font.BOLD, 16));
		
		meaningListTxt = new JTextField();
		meaningListTxt.setColumns(10);
		
		JLabel tip = new JLabel("\u5982\u679C\u6709\u591A\u4E2A\uFF0C\u7528\u5206\u53F7\u9694\u5F00");
		tip.setFont(new Font("���� Light", Font.PLAIN, 11));
		
		JLabel egLabel = new JLabel("\u4F8B\u53E5\uFF1A");
		egLabel.setFont(new Font("����", Font.BOLD, 16));
		
		egTxt = new JTextField();
		egTxt.setColumns(10);
		
		JLabel transLabel = new JLabel("\u4F8B\u53E5\u7FFB\u8BD1\uFF1A");
		transLabel.setFont(new Font("����", Font.BOLD, 16));
		
		transTxt = new JTextField();
		transTxt.setColumns(10);
		
		JLabel vidLabel = new JLabel("\u6240\u5C5E\u8868\u5355\uFF1A");
		vidLabel.setFont(new Font("����", Font.BOLD, 16));
		
		vocabularyListCb = new JComboBox();
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWordActionPerformed(e);
			}
		});
		addButton.setFont(new Font("����", Font.BOLD, 23));
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFormActionPerformed(e);
			}
		});
		resetButton.setFont(new Font("Dialog", Font.BOLD, 23));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(wordLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(wordTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(meaningListLabel, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(egLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(meaningListTxt, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(tip))
								.addComponent(egTxt, 476, 476, 476)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(transLabel)
							.addGap(18)
							.addComponent(transTxt, GroupLayout.PREFERRED_SIZE, 476, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(vidLabel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(vocabularyListCb, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(resetButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(addButton)))
					.addGap(41))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(wordLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(wordTxt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(meaningListLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(meaningListTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(tip, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(egLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(egTxt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(transLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(transTxt, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(vidLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(vocabularyListCb, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
							.addGap(30))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(addButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGap(32))))
		);
		panel.setLayout(gl_panel);
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
