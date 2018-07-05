package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class wordlistadd extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wordlistadd frame = new wordlistadd();
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
	public wordlistadd() {
		setMaximizable(true);
		setBounds(100, 100, 450, 300);

	}

}
