package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutUs extends JInternalFrame {
	private JTextField qqMailTxt;
	private JTextField gitLinkTxt;
	private JButton copyButton;
	private static Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AboutUs frame = new AboutUs();
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
	public AboutUs() {
		setResizable(true);
		setTitle("关于我们");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 728, 560);
		getContentPane().setLayout(null);

		JLabel CopyrightLabel = new JLabel("Copyright  ©  2018   WJLGH corporation .All rights reserved. ");
		CopyrightLabel.setBounds(117, 442, 496, 18);
		getContentPane().add(CopyrightLabel);

		JLabel makerLabel = new JLabel("制作人员：");
		makerLabel.setFont(new Font("黑体", Font.BOLD, 22));
		makerLabel.setBounds(70, 90, 115, 38);
		getContentPane().add(makerLabel);

		JLabel impleHeadLabel = new JLabel("功能实现：");
		impleHeadLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		impleHeadLabel.setBounds(231, 251, 100, 29);
		getContentPane().add(impleHeadLabel);

		JLabel impleLabel2 = new JLabel("李东");
		impleLabel2.setFont(new Font("宋体", Font.PLAIN, 20));
		impleLabel2.setBounds(353, 294, 96, 29);
		getContentPane().add(impleLabel2);

		JLabel impleLabel3 = new JLabel("王京龙");
		impleLabel3.setFont(new Font("宋体", Font.PLAIN, 20));
		impleLabel3.setBounds(353, 333, 96, 29);
		getContentPane().add(impleLabel3);

		JLabel impleLabel1 = new JLabel("宋培培");
		impleLabel1.setFont(new Font("宋体", Font.PLAIN, 20));
		impleLabel1.setBounds(353, 252, 96, 29);
		getContentPane().add(impleLabel1);

		JLabel dbdesignHeadLabel = new JLabel("数据库设计：");
		dbdesignHeadLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dbdesignHeadLabel.setBounds(204, 167, 120, 29);
		getContentPane().add(dbdesignHeadLabel);

		JLabel dbdesignerLabel1 = new JLabel("李东");
		dbdesignerLabel1.setFont(new Font("宋体", Font.PLAIN, 20));
		dbdesignerLabel1.setBounds(350, 167, 96, 29);
		getContentPane().add(dbdesignerLabel1);

		JLabel dbdesignerLabel2 = new JLabel("王京龙");
		dbdesignerLabel2.setFont(new Font("宋体", Font.PLAIN, 20));
		dbdesignerLabel2.setBounds(348, 209, 96, 29);
		getContentPane().add(dbdesignerLabel2);

		JLabel artHeadLabel = new JLabel("美工：");
		artHeadLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		artHeadLabel.setBounds(263, 125, 60, 29);
		getContentPane().add(artHeadLabel);

		JLabel artLabel = new JLabel("宋培培");
		artLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		artLabel.setBounds(349, 125, 96, 29);
		getContentPane().add(artLabel);

		JLabel contactHead = new JLabel("联系我们：");
		contactHead.setBounds(204, 386, 81, 18);
		getContentPane().add(contactHead);

		JLabel gitHeadLabel = new JLabel("项目Git地址：");
		gitHeadLabel.setFont(new Font("黑体", Font.BOLD, 22));
		gitHeadLabel.setBounds(70, 39, 153, 38);
		getContentPane().add(gitHeadLabel);

		qqMailTxt = new JTextField();
		qqMailTxt.setEditable(false);
		qqMailTxt.setText("1179315470@qq.com");
		qqMailTxt.setBounds(286, 383, 163, 21);
		getContentPane().add(qqMailTxt);
		qqMailTxt.setColumns(10);

		gitLinkTxt = new JTextField();
		gitLinkTxt.setEditable(false);
		gitLinkTxt.setText("https://github.com/WJLGH/studyEnglish");
		gitLinkTxt.setBounds(222, 49, 305, 24);
		getContentPane().add(gitLinkTxt);
		gitLinkTxt.setColumns(10);
		
		copyButton = new JButton("复制");
		copyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				copyActionPerformed(e);
			}
		});
		copyButton.setBounds(541, 48, 90, 27);
		getContentPane().add(copyButton);
		setVisible(true);
	}
	

	private void copyActionPerformed(ActionEvent e) {
		if(e.getSource()==copyButton) {
			setSysClipboardText(this.gitLinkTxt.getText());
			JOptionPane.showMessageDialog(null, "复制成功");
		}
	}

	public void setSysClipboardText(String writeMe) {
		Transferable tText = new StringSelection(writeMe);
		clip.setContents(tText, null);
	}
}
