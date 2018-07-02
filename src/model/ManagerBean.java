package model;

import java.util.Date;

public class ManagerBean {
	private int mid;
	private String mname;
	private String mpwd;
	private Date lastlogin;

	public ManagerBean() {

	}

	public ManagerBean(int mid, String mname, String mpwd, Date lastlogin) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mpwd = mpwd;
		this.lastlogin = lastlogin;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public Date getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	@Override
	public String toString() {
		return "ManagerBean [mid=" + mid + ", mname=" + mname + ", mpwd=" + mpwd + ", lastlogin=" + lastlogin + "]";
	}

}
