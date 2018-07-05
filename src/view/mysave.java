package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class mysave extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mysave frame = new mysave();
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
	public mysave() {
		setBounds(100, 100, 450, 300);

	}

}
