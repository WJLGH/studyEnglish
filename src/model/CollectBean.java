package model;
import java.util.*;
public class CollectBean {
	private int sid;
	private int uid;
	private int wid;
	
	public CollectBean() {
	}

	public CollectBean(int uid,int wid) {
		super();
		this.uid=uid;
		this.wid=wid;
	}
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	@Override
	public String toString() {
		return "CollectBean [sid=" + sid + ", uid=" + uid + ", wid=" + wid + "]";
	}
	
	
	
}
