package model;

import java.util.List;

public class UserBean {
	private int uid;
	private String uname;


	private String upwd;
	private int upage;
<<<<<<< HEAD
	private List<WordBean> collect;

	public UserBean() {

	}

	public UserBean(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}
=======
	
>>>>>>> caf826ba7066b81cb3c7f106ac46e9ac82a47f6d

	public UserBean() {

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
