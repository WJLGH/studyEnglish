package view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import dao.CollectDao;
import dao.WordDao;
import model.UserBean;
import model.CollectBean;
import model.MeaningBean;
import model.UserBean;
import model.WordBean;
import util.BaiDuTranslationUtils;
import util.CharacterUtil;

import java.awt.event.InputMethodListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class EnZhseek extends JInternalFrame {
	JList wordList;
	private JTextField searchWord;
	JScrollPane scrollPane;
	private JLabel meanigLabel;
	private JLabel egLabel;
	private JLabel headEgLabel;
	private JLabel transLabel;
	private JLabel headTransLabel;
	private JButton collectButton;
	JPanel wordShowPanel;
	JLabel wordEnglishLabel;
	WordBean nowWord;
	private UserBean user;
	private JLabel headNetMeanigLabel;
	private JLabel netMeaingLabel;
	private JPanel panel_1;
	private JLabel headNetWordLabel;
	private JLabel netWordLabel;
	public EnZhseek(UserBean user) {
		setIconifiable(true);
		setClosable(true);
		this.user = user;
		Container panel = getContentPane();
		getContentPane().setLayout(null);
		wordList = new JList();
		wordList.setBounds(49, 78, 468, 145);
		wordList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showSeletItem();
			}
		});
		scrollPane = new JScrollPane(wordList);
		scrollPane.setBounds(49, 78, 489, 145);
		panel.add(scrollPane);
		
		searchWord = new JTextField();
		Document dc = searchWord.getDocument();
		dc.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
				inputChangedActionPerformed();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				inputChangedActionPerformed();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				inputChangedActionPerformed();
			}
		});
		
		searchWord.setBounds(49, 54, 468, 24);
		getContentPane().add(searchWord);
		searchWord.setColumns(10);
		
		JButton resetSearchWord = new JButton("");
		resetSearchWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetSearchTxtActionPerformed(e);
			}
		});
		resetSearchWord.setIcon(new ImageIcon(EnZhseek.class.getResource("/image/delete.png")));
		resetSearchWord.setBounds(514, 54, 24, 24);
		getContentPane().add(resetSearchWord);
		
		wordShowPanel = new JPanel();
		wordShowPanel.setBounds(49, 106, 489, 284);
		getContentPane().add(wordShowPanel);
		wordShowPanel.setLayout(null);
		
		wordEnglishLabel = new JLabel("null");
		wordEnglishLabel.setBounds(31, 28, 138, 42);
		wordEnglishLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		wordShowPanel.add(wordEnglishLabel);
		
		meanigLabel = new JLabel("无");
		meanigLabel.setFont(new Font("黑体", Font.PLAIN, 17));
		meanigLabel.setBounds(31, 104, 433, 34);
		wordShowPanel.add(meanigLabel);
		
		egLabel = new JLabel("null");
		egLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		egLabel.setBounds(83, 179, 381, 25);
		wordShowPanel.add(egLabel);
		
		headEgLabel = new JLabel("eg:");
		headEgLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		headEgLabel.setBackground(SystemColor.menu);
		headEgLabel.setBounds(31, 170, 30, 34);
		wordShowPanel.add(headEgLabel);
		
		transLabel = new JLabel("无");
		transLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		transLabel.setBounds(82, 231, 382, 32);
		wordShowPanel.add(transLabel);
		
		headTransLabel = new JLabel("译：");
		headTransLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		headTransLabel.setBackground(SystemColor.menu);
		headTransLabel.setBounds(31, 231, 38, 34);
		wordShowPanel.add(headTransLabel);
		
		collectButton = new JButton("收藏");
		collectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				collectActionPerformed(e);
			}
		});
		collectButton.setBounds(338, 37, 85, 34);
		wordShowPanel.add(collectButton);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u7F51\u7EDC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(49, 392, 488, 78);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		headNetMeanigLabel = new JLabel("释义：");
		headNetMeanigLabel.setBounds(246, 31, 45, 20);
		panel_1.add(headNetMeanigLabel);
		headNetMeanigLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		headNetMeanigLabel.setBackground(SystemColor.menu);
		
		netMeaingLabel = new JLabel("无");
		netMeaingLabel.setBounds(375, 29, 103, 25);
		panel_1.add(netMeaingLabel);
		netMeaingLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		netMeaingLabel.setBackground(SystemColor.menu);
		
		headNetWordLabel = new JLabel("单词：");
		headNetWordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		headNetWordLabel.setBackground(SystemColor.menu);
		headNetWordLabel.setBounds(27, 31, 45, 20);
		panel_1.add(headNetWordLabel);
		
		netWordLabel = new JLabel("无");
		netWordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		netWordLabel.setBackground(SystemColor.menu);
		netWordLabel.setBounds(85, 29, 87, 25);
		panel_1.add(netWordLabel);
		setBounds(100,100,608,510);
		setVisible(true);
		this.wordShowPanel.setVisible(false);
		this.scrollPane.setVisible(false);
	}
	
	private void collectActionPerformed(ActionEvent e) {
		boolean isSuccess = false;
		try {
			isSuccess = CollectDao.addCollectBean(new CollectBean(user.getUid(), this.nowWord.getWid()));
			if(isSuccess) {
				JOptionPane.showMessageDialog(null, "收藏成功");
			} else {
				JOptionPane.showMessageDialog(null, "收藏失败");
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "收藏失败");
			e1.printStackTrace();
		}
	}

	private void resetSearchTxtActionPerformed(ActionEvent e) {
		this.searchWord.setText("");
	}

	private void resetWordShowPanelItems() {
		this.wordShowPanel.setVisible(false);
		
	}
	private void showSeletItem() {
		System.out.println("选中");
		nowWord =  (WordBean) wordList.getSelectedValue();
		if(nowWord != null) {
			this.searchWord.setText(nowWord.getWord());
			this.wordEnglishLabel.setText(nowWord.getWord());
			this.egLabel.setText(nowWord.getEg());
			this.transLabel.setText(nowWord.getTrans());
			StringBuffer sb = new StringBuffer();
			for(MeaningBean mb :nowWord.getMeans()) {
				sb.append(mb.getChinese()+";");
			}
			this.meanigLabel.setText(sb.toString());
		}
		this.scrollPane.setVisible(false);
		this.wordShowPanel.setVisible(true);
		repaint();
	}
	protected  void inputChangedActionPerformed( ) {
		
		this.scrollPane.setVisible(true);
		String input = searchWord.getText();
		System.out.println("输入"+input);
		Vector v = new Vector();
		if(CharacterUtil.isWord(input)) {
			System.out.println("英文查询");
			try {
				List<WordBean> result = WordDao.fuzzySearchWordBean(input);
				if(result != null) {
					for (WordBean wordBean : result) {
						v.addElement(wordBean);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("中文查询");
			try {
				List<WordBean> result = WordDao.zhQueryEn(input);
				if(result != null) {
					for (WordBean wordBean : result) {
						v.addElement(wordBean);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		wordList.setListData(v);
		this.netMeaingLabel.setText(BaiDuTranslationUtils.tranlate(searchWord.getText(), "zh"));
		this.netWordLabel.setText(BaiDuTranslationUtils.tranlate(searchWord.getText(), "en"));
	}
	public static void main(String[] args) {
		new EnZhseek(new UserBean(1, "123", "123", 0));
	}
}
