package model;

import java.util.List;

public class UserBean {
	private int uid;
	private String uname;


	private String upwd;
	private int upage;

<<<<<<< HEAD
	private List<WordBean> collect;
=======
>>>>>>> 22949b88997100e8123c7497deba00ed74bcbd02

	public UserBean() {

	}

	public UserBean(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}



	public UserBean(int uid, String uname, String upwd, int upage) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.upage = upage;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public int getUpage() {
		return upage;
	}

	public void setUpage(int upage) {
		this.upage = upage;
	}

	@Override
	public String toString() {
		return "UserBean [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", upage=" + upage + "]";
	}

}
