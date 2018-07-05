package view;

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
	UserBean user;
	Timer timer;
	ReciteWords rw;
	WordBean nowWord;
	JTextArea area;
	JButton next = new JButton("下一个");
	JButton like = new JButton("收藏");
	JButton delete = new JButton("斩");
	public ReciteWordView(UserBean user) {
		this.user = user;
		rw = new ReciteWords(user);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		area = new JTextArea(5, 3);
		JScrollPane jScrollPane = new JScrollPane(area);
		contentPane.add(jScrollPane);
		contentPane.add(next);
		contentPane.add(like);
		contentPane.add(delete);
		next.addActionListener(this);
		like.addActionListener(this);
		delete.addActionListener(this);
		
		timer = new Timer(3000, this);
		jScrollPane.setBounds(20, 20, 800, 200);
		next.setBounds(400, 400, 100, 50);
		like.setBounds(400, 450, 100, 50);
		delete.setBounds(400, 490, 100, 50);
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAreaText();
	}
	public void setAreaText() {
		if(rw.isFinish()) {
			try {
				timer.stop();
				System.out.println("保存");
				rw.saveUserPage();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "背完了今天的单词");
			this.dispose();
		}
		
		nowWord = rw.getNext();
		if( nowWord != null ) {
			area.setText(nowWord.toString());
		}
		
		repaint();
		timer.restart();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == timer) {
			setAreaText();
		}
		
		if(e.getSource() == next) {
			setAreaText();
		}
		if(e.getSource() == like) {
			try {
				rw.addCollectBean(nowWord.getWid());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			setAreaText();
		}
		if(e.getSource() == delete) {
			rw.removeFromList();
			setAreaText();
		}
	}
	public static void main(String[] args) {
		try {
			new ReciteWordView(UserDao.checkLogin("user1","123456"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
