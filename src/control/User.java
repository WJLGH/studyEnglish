package control;

import model.UserBean;
import java.util.Map;

public class User {
	public static UserBean u;
	public static Map<String, ItemFunc> map;
	// 初始化功能设置
	static {
		
	}

	public static UserBean getU() {
		return u;
	}

	public static void setU(UserBean u) {
		User.u = u;
	}

	public static Map<String, ItemFunc> getMap() {
		return map;
	}

	public static void setMap(Map<String, ItemFunc> map) {
		User.map = map;
	}

}
