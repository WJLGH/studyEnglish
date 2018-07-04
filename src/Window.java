import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

public class Window extends JFrame implements ActionListener{
	LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 150,4,150);
	JLabel label ;
	JButton check;
	JButton change;
	JTextField code;
	 public Window() {
         setTitle("图像测试");
         Container panel =  this.getContentPane();
         panel.setLayout(new GridLayout(4, 1));
         label = new JLabel();
         label.setIcon(getPic());
         check = new JButton("验证");
         change = new JButton("换一张");
         code = new JTextField(10);
         check.addActionListener(this);
         change.addActionListener(this);
         panel.add(label);
         panel.add(check);
         panel.add(change);
         panel.add(code);
         setExtendedState(JFrame.MAXIMIZED_BOTH);// JFrame最大化
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 让JFrame的关闭按钮起作用
         setVisible(true);// 显示JFrame
     }
	 
	 public void getCaptcha() {
		 lineCaptcha = CaptchaUtil.createLineCaptcha(200, 150,4,150);
		 ImageIcon img = getPic();// 创建图片对象
		 label.setIcon(getPic());
	 }
     public ImageIcon getPic() {
 		//LineCaptcha lineCaptcha = new LineCaptcha(200, 100, 4, 150);
 		//图形验证码写出，可以写出到文件，也可以写出到流
 		ByteArrayOutputStream baos = new ByteArrayOutputStream();
 		lineCaptcha.write(baos);
 		ImageIcon image = new ImageIcon(baos.toByteArray());
		return image;
     }
     public boolean verify(String code) {
    	 //验证图形验证码的有效性，返回boolean
    	 return lineCaptcha.verify(code);
     }

	public static void main(String args[]) {
		Window d = new Window();
	}

	@Override
	public void actionPerformed(ActionEvent  e) {
		if(e.getActionCommand() == "验证") {
			
			String input = code.getText().trim();
			if(verify(input)) {
				JOptionPane.showMessageDialog(this, "正确", "", JOptionPane.WARNING_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "错误", "", JOptionPane.WARNING_MESSAGE);
			}
		} else {
			System.out.println("gengxin");
			getCaptcha();
			validate();
			repaint();
		}
	}

}
