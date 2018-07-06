package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.UserBean;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class usermainfrm extends JFrame {

	private JPanel contentPane;
	JDesktopPane Table = null;
	private UserBean user;

	/**
	 * Create the frame.
	 */
	public usermainfrm(UserBean user) {
		this.user = user;
		setTitle("\u7528\u6237\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 468);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mydictionarymenu = new JMenu("\u6211\u7684\u8BCD\u5178       ");
		mydictionarymenu.setIcon(new ImageIcon(usermainfrm.class.getResource("/image/bookManager.png")));
		menuBar.add(mydictionarymenu);
		
		JMenu searchmenu = new JMenu("\u67E5\u627E\u65B9\u5F0F");
		mydictionarymenu.add(searchmenu);
		
		JMenuItem EnZhmenu = new JMenuItem("\u82F1\u8BD1\u6C49");
		EnZhmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enseekzhActionPerformed(e);
			}
		});
		searchmenu.add(EnZhmenu);
		
		JMenuItem ZhEnmenu = new JMenuItem("\u6C49\u8BD1\u82F1");
		ZhEnmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zhenseekActionPerformed(e);
			}
		});
		searchmenu.add(ZhEnmenu);
		
		JMenu mycollectmenu = new JMenu("\u6211\u7684\u6536\u85CF");
		mydictionarymenu.add(mycollectmenu);
		
		JMenuItem vocabularylistmenu = new JMenuItem("\u5355\u8BCD\u8868");
		vocabularylistmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mysaveActionPerformed(e);
			}
		});
		mycollectmenu.add(vocabularylistmenu);
		
		JMenuItem myachievemenu = new JMenuItem("我的成就");
		mydictionarymenu.add(myachievemenu);
		
		JMenuItem recitemenu = new JMenuItem("背诵单词");
		recitemenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reciteActionPerforemd(e);
			}
		});
		mydictionarymenu.add(recitemenu);
		
		JMenu securitymenu = new JMenu("\u5B89\u5168        ");
		securitymenu.setIcon(new ImageIcon(usermainfrm.class.getResource("/image/base.png")));
		menuBar.add(securitymenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		securitymenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		securitymenu.add(mntmNewMenuItem_3);
		
		JMenu aboutusmenu = new JMenu("\u5173\u4E8E\u6211\u4EEC    ");
		aboutusmenu.setIcon(new ImageIcon(usermainfrm.class.getResource("/image/about.png")));
		menuBar.add(aboutusmenu);
		
		JMenuItem contactusmenu = new JMenuItem("\u8054\u7CFB\u6211\u4EEC");
		aboutusmenu.add(contactusmenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Table = new JDesktopPane();
		Table.setBackground(Color.GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Table, GroupLayout.PREFERRED_SIZE, 1347, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(Table, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		GroupLayout gl_Table = new GroupLayout(Table);
		gl_Table.setHorizontalGroup(
			gl_Table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1347, Short.MAX_VALUE)
		);
		gl_Table.setVerticalGroup(
			gl_Table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 659, Short.MAX_VALUE)
		);
		Table.setLayout(gl_Table);
		contentPane.setLayout(gl_contentPane);
		setExtendedState(MAXIMIZED_BOTH);
		this.setVisible(true);
	}


	private void reciteActionPerforemd(ActionEvent e) {
		ReciteWordView rwv = new ReciteWordView(user);
		Table.add(rwv);
	}

	private void mysaveActionPerformed(ActionEvent evt) {
		mysave save =new mysave();
		save.setVisible(true);
		Table.add(save);
	}


	private void zhenseekActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		ZhEnseek zhenseek = new ZhEnseek();
		zhenseek.setVisible(true);
		Table.add(zhenseek);
		
	}

	private void enseekzhActionPerformed(ActionEvent evt) {
		EnZhseek enzhseek = new EnZhseek();
		enzhseek.setVisible(true);
		Table.add(enzhseek);
	}
}
