package model;

import java.util.List;

public class VocabularyBean {
	private int vid;
	private String vname;
	private List<WordBean> list;
	
	public VocabularyBean() {
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public List<WordBean> getList() {
		return list;
	}

	public void setList(List<WordBean> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "VocabularyBean [vid=" + vid + ", vname=" + vname + ", list=" + list + "]";
	}
	
	
	
}
