package util;

import java.io.ByteArrayOutputStream;

import javax.swing.ImageIcon;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

public class CaptchaUtils {
	private static LineCaptcha lineCaptcha = null;

	/**
	 * ˢ�²��������볤�� �µ���֤��
	 * 
	 * @param length
	 * @param width
	 */
	public static void getNewCaptcha(int length, int width) {
		lineCaptcha = CaptchaUtil.createLineCaptcha(length, width, 4, 200);
	}

	/**
	 * ����һ����֤��ͼƬ
	 * 
	 * @return
	 */
	public static ImageIcon getPic() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		lineCaptcha.write(baos);
		ImageIcon image = new ImageIcon(baos.toByteArray());
		return image;
	}

	/**
	 * ��֤�û�������ַ����Ƿ���ͼƬ��Ӧ
	 * 
	 * @param code
	 * @return
	 */
	public static boolean verify(String code) {
		// ��֤ͼ����֤�����Ч�ԣ�����boolean
		return lineCaptcha.verify(code);
	}

}
