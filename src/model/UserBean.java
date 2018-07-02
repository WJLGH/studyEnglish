package model;

public class UserBean {
	private int uid;
	private String uname;
	private String upwd;
	private String upage;

	public UserBean() {

	}

	public UserBean(int uid, String uname, String upwd, String upage) {
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

	public String getUpage() {
		return upage;
	}

	public void setUpage(String upage) {
		this.upage = upage;
	}

	@Override
	public String toString() {
		return "UserBean [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", upage=" + upage + "]";
	}

}
