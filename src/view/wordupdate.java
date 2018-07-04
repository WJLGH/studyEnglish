package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class wordupdate extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordupdate frame = new wordupdate();
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
	public wordupdate() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u66F4\u65B0\u5355\u8BCD");
		setBounds(100, 100, 450, 300);

	}

}
