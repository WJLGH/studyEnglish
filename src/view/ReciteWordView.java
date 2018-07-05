package view;

import model.MeaningBean;
import model.UserBean;
import model.WordBean;
import util.JDBCUtils;

import javax.swing.*;

import control.ReciteWords;
import dao.UserDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ReciteWordView extends JFrame implements ActionListener{
	private UserBean user;
	private Timer timer;
	private ReciteWords rw;
	private WordBean nowWord;
	private JLabel wordLabel ;
	private JButton like = new JButton("收藏");
	private JButton delete = new JButton("斩");
	private  JLabel meaingLabel = new JLabel("新，标签");
	private  JLabel egHeadLabel = new JLabel("eg:");
	private  JLabel egLabel = new JLabel("This is a new label.");
	private  JLabel transLabel = new JLabel("这是一个新标签");
	private  JLabel label = new JLabel("译：");
	public ReciteWordView(UserBean user) {
		this.user = user;
		rw = new ReciteWords(user);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		like.setIcon(new ImageIcon(ReciteWordView.class.getResource("/image/add.png")));
		contentPane.add(like);
		delete.setIcon(new ImageIcon(ReciteWordView.class.getResource("/image/delete.png")));
		contentPane.add(delete);
		like.addActionListener(this);
		delete.addActionListener(this);
		
		timer = new Timer(3000, this);
		like.setBounds(516, 76, 85, 34);
		delete.setBounds(288, 397, 100, 50);
		
		wordLabel = new JLabel("New label");
		wordLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 30));
		wordLabel.setBounds(127, 48, 172, 79);
		getContentPane().add(wordLabel);
		meaingLabel.setFont(new Font("黑体", Font.PLAIN, 17));
		meaingLabel.setBounds(127, 171, 382, 34);
		
		getContentPane().add(meaingLabel);
		egHeadLabel.setBackground(new Color(240, 240, 240));
		egHeadLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		egHeadLabel.setBounds(126, 218, 38, 34);
		
		getContentPane().add(egHeadLabel);
		egLabel.setFont(new Font("����", Font.PLAIN, 17));
		egLabel.setBounds(178, 227, 423, 25);
		
		getContentPane().add(egLabel);
		transLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		transLabel.setBounds(178, 265, 413, 32);
		
		getContentPane().add(transLabel);
		label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 17));
		label.setBackground(SystemColor.menu);
		label.setBounds(127, 265, 38, 34);
		
		getContentPane().add(label);
		setSize(721, 598);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recite();
	}
	
	public void recite() {
		if(rw.isFinish()) {
			try {
				timer.stop();
				rw.saveUserPage();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "呀，今天的单词背完了");
			this.dispose();
		}
		
		nowWord = rw.getNext();
		if( nowWord != null ) {
			showNowWord();
		}
		
		repaint();
		timer.restart();
	}
	private void showNowWord() {
		this.wordLabel.setText(nowWord.getWord());
		this.egLabel.setText(nowWord.getEg());
		StringBuffer sb = new StringBuffer();
		for(MeaningBean meaning: nowWord.getMeans()) {
			sb.append(meaning.getChinese()+",");
		}
		this.meaingLabel.setText(sb.toString());
		this.transLabel.setText(nowWord.getTrans());
		
	}

	public static void main(String[] args) {
		try {
			new ReciteWordView(UserDao.checkLogin("user1","123456"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if( s == this.like) {
			try {
				rw.addCollectBean(nowWord.getWid());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(s == this.delete) {
			rw.removeFromList();
		}
		timer.restart();
		recite();
	}
}
