package control;

import java.util.Map;

import model.ManagerBean;

public class Manager {
	public static ManagerBean m;
	public static Map<String, ItemFunc> map;
	// ��ʼ����������
	static {

	}

	public static ManagerBean getM() {
		return m;
	}

	public static void setM(ManagerBean m) {
		Manager.m = m;
	}

	public static Map<String, ItemFunc> getMap() {
		return map;
	}

	public static void setMap(Map<String, ItemFunc> map) {
		Manager.map = map;
	}
}
