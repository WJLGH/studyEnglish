package view;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import java.awt.event.InputMethodListener;
import java.util.Vector;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class testJList extends JFrame {
	String[] s=new String[]{"�ձ�","Ӣ��","����","�й�","����","a","abc","b","bcd","c","cdf"};
	JList jList;
	private JTextField countryName;
	private JLabel label;
	private JTextField selectCountryTxt;
	JScrollPane scrollPane;
	public testJList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container panel = getContentPane();
		getContentPane().setLayout(null);
		jList = new JList(s);
		jList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				showSeletItem();
			}
		});
		scrollPane = new JScrollPane(jList);
		scrollPane.setBounds(283, 63, 104, 114);
		panel.add(scrollPane);
		
		countryName = new JTextField();
		countryName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				showScrollPane();
			}
			@Override
			public void focusLost(FocusEvent e) {
				destroyScrollPane();
			}
		});
		Document dc = countryName.getDocument();
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
		
		countryName.setBounds(283, 39, 104, 24);
		getContentPane().add(countryName);
		countryName.setColumns(10);
		
		label = new JLabel("\u4F60\u9009\u4E2D\u4E86\uFF1A");
		label.setBounds(73, 478, 97, 18);
		getContentPane().add(label);
		
		selectCountryTxt = new JTextField();
		selectCountryTxt.setBounds(178, 475, 151, 24);
		getContentPane().add(selectCountryTxt);
		selectCountryTxt.setColumns(10);
		setBounds(100,100,600,600);
		setVisible(true);
		this.scrollPane.setVisible(false);
	}
	protected void destroyScrollPane() {
		this.scrollPane.setVisible(false);
		
	}
	protected void showScrollPane() {
		this.scrollPane.setVisible(true);
	}
	private void showSeletItem() {
		String s = (String) jList.getSelectedValue();
		selectCountryTxt.getFocusAccelerator();
		selectCountryTxt.setText(s);
	}
	protected  void inputChangedActionPerformed( ) {
		String input = countryName.getText();
		System.out.println("��ǰ����Ϊ��"+input);
		Vector v = new Vector();
		for(String str:s) {
			if(str.contains(input)) {
				v.addElement(str);
			}
		}
		jList.setListData(v);
		
	}
	public static void main(String[] args) {
		new testJList();
	}
}
