package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class managermainfrm extends JFrame {
	private JPanel contentPane;
	private JDesktopPane Table = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managermainfrm frame = new managermainfrm();
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
	public managermainfrm() {
		setTitle("\u7BA1\u7406\u5458\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 401);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4       ");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_5 = new JMenu("\u8BCD\u6C47\u7EF4\u62A4");
		mnNewMenu.add(mnNewMenu_5);
		
		JMenuItem menuItem_3 = new JMenuItem("\u589E\u52A0\u8BCD\u6C47");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordaddActionPerformed(e);
			}
		});
		mnNewMenu_5.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u7BA1\u7406\u8BCD\u6C47");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordupdateActionPerformed(e);
			}
		});
		mnNewMenu_5.add(menuItem_4);
		
		
		JMenu mnNewMenu_6 = new JMenu("\u8BCD\u6C47\u8868\u7EF4\u62A4");
		mnNewMenu.add(mnNewMenu_6);
		
		JMenuItem menuItem_6 = new JMenuItem("\u589E\u52A0");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordlistActionPerformed(e);
			}
		});
		mnNewMenu_6.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u7BA1\u7406");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordlistupdateActionPerformed(e);
			}
		});
		mnNewMenu_6.add(menuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("\u6570\u636E\u5E93\u7BA1\u7406          ");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_4 = new JMenu("\u6570\u636E\u5E93\u5907\u4EFD\u4E0E\u8FD8\u539F");
		mnNewMenu_1.add(mnNewMenu_4);
		
		JMenuItem menuItem_2 = new JMenuItem("\u6570\u636E\u5E93\u5907\u4EFD");
		mnNewMenu_4.add(menuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6570\u636E\u5E93\u8FD8\u539F");
		mnNewMenu_4.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("\u7CFB\u7EDF\u5B89\u5168      ");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateActionPerformed(e);
			}
		});
		mnNewMenu_2.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA");
		menuItem_1.addActionListener(new ActionListener() {
			/**
			 * 是否确认退出
			 */
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"是否确认退出！");
				if(result ==0)
					dispose();
			}
		});
		mnNewMenu_2.add(menuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E");
		mnNewMenu_3.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		 Table= new JDesktopPane();
		Table.setBackground(Color.GRAY);
		contentPane.add(Table, BorderLayout.CENTER);
		this.setExtendedState(MAXIMIZED_BOTH);
	}

	private void wordupdateActionPerformed(ActionEvent e) {
		wordupdate word = new wordupdate();
		word.setVisible(true);
		Table.add(word);
		
	}

	private void wordlistActionPerformed(ActionEvent e) {
		wordlistadd wordlist = new wordlistadd();
		wordlist.setVisible(true);
		Table.add(wordlist);
	}

	private void wordlistupdateActionPerformed(ActionEvent evt) {
		wordlistpdate wordlist = new wordlistpdate();
		wordlist.setVisible(true);
		Table.add(wordlist);
		
	}

	private void wordaddActionPerformed(ActionEvent evt) {
		wordadd word = new wordadd();
		word.setVisible(true);
		Table.add(word);		
	}

	private void updateActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		new mupdatepwdfem().setVisible(true);
	}
}
