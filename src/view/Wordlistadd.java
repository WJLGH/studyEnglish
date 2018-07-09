package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.VocabularyDao;
import model.VocabularyBean;
import util.CharacterUtil;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Wordlistadd extends JInternalFrame {
	private JTextField nameTxt;
	private JTextArea descArea;
	private JButton addButton;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Wordlistadd frame = new Wordlistadd();
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
	public Wordlistadd() {
		setClosable(true);
		setIconifiable(true);
		setTitle("添加词汇表");
		setBounds(100, 100, 470, 321);
		
		JLabel nameLabel = new JLabel("词汇表名称:");
		
		nameTxt = new JTextField();
		nameTxt.setColumns(10);
		
		JLabel descLabel = new JLabel("词汇表描述:");
		
		descArea = new JTextArea();
		
		addButton = new JButton("提交");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addWordListActionPerformed(e);
			}
		});
		addButton.setFont(new Font("Dialog", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(descLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(nameLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(descArea, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(65, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(addButton)
					.addGap(190))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLabel)
						.addComponent(nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(descLabel)
						.addComponent(descArea, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(addButton)
					.addGap(41))
		);
		getContentPane().setLayout(groupLayout);
		
	}

	private void addWordListActionPerformed(ActionEvent e) {
		String name = this.nameTxt.getText();
		String desc = this.descArea.getText();
		if(CharacterUtil.isEmpty(name) ) {
			JOptionPane.showMessageDialog(null, "词汇表名不能为空");
			return ;
		}
		if(CharacterUtil.isEmpty(desc)) {
			JOptionPane.showMessageDialog(null, "描述不能为空");
			return ;
		}
		VocabularyBean vb = new VocabularyBean();
		vb.setVname(name);
		vb.setVdesc(desc);
		boolean isSuccess = false;
		try {
			isSuccess = VocabularyDao.addVocabularyBean(vb);
			if(isSuccess == true) {
				JOptionPane.showMessageDialog(null, "添加成功");
			} else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "添加失败");
			e1.printStackTrace();
		}
	}

}
