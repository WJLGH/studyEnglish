package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Myachieve extends JInternalFrame {
	Map<Integer, ImageIcon> reflect = new HashMap<Integer, ImageIcon>();
	public static int picCnt = 5;

	/**
	 * Create the frame.
	 */
	public Myachieve(int upage) {
		initReflectMap();
		setTitle("\u6211\u7684\u6210\u5C31");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 528, 420);

		JLabel numberLabel = new JLabel("您已经背诵了");
		numberLabel.setBounds(39, 49, 150, 29);
		numberLabel.setFont(new Font("����", Font.BOLD, 24));

		JLabel upageLabel = new JLabel("");
		upageLabel.setBounds(195, 49, 36, 29);
		upageLabel.setFont(new Font("Dialog", Font.BOLD, 24));

		JLabel label_1 = new JLabel("个单词");
		label_1.setBounds(227, 49, 87, 29);
		label_1.setFont(new Font("Dialog", Font.BOLD, 24));

		JLabel label = new JLabel("获得成就：");
		label.setBounds(39, 96, 133, 29);
		label.setFont(new Font("Dialog", Font.BOLD, 24));
		getContentPane().setLayout(null);

		JLabel iconPicPos = new JLabel("");
		iconPicPos.setBounds(200, 159, 133, 112);
		getContentPane().add(iconPicPos);
		getContentPane().add(label);
		getContentPane().add(numberLabel);
		getContentPane().add(upageLabel);
		getContentPane().add(label_1);

		setAchieve(upage, upageLabel, iconPicPos);

		setVisible(true);
	}

	private void setAchieve(int upage, JLabel upageLabel, JLabel iconPicPos) {
		upageLabel.setText("" + upage);
		upage = upage >= 50 ? 40 : upage;
		iconPicPos.setIcon(reflect.get(upage / 10));
	}

	private void initReflectMap() {
		for (int i = 0; i < picCnt; i++) {
			reflect.put(i, new ImageIcon(Myachieve.class.getResource("/image/" + i + ".jpg")));
		}
	}
}
