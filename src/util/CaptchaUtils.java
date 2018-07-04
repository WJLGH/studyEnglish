package util;

import java.io.ByteArrayOutputStream;

import javax.swing.ImageIcon;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

public class CaptchaUtils {
	private static LineCaptcha lineCaptcha = null;

	/**
	 * 刷新产生所传入长宽 新的验证码
	 * 
	 * @param length
	 * @param width
	 */
	public static void getNewCaptcha(int length, int width) {
		lineCaptcha = CaptchaUtil.createLineCaptcha(length, width, 4, 200);
	}

	/**
	 * 产生一个验证码图片
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
	 * 验证用户输入的字符串是否与图片对应
	 * 
	 * @param code
	 * @return
	 */
	public static boolean verify(String code) {
		// 验证图形验证码的有效性，返回boolean
		return lineCaptcha.verify(code);
	}

}
