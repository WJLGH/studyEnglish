package model;

import java.util.List;

public class VocabularyBean {
	private int vid;

	private String vname;
	private String vdesc;

	public VocabularyBean() {
		
	}

	public VocabularyBean(int vid, String vname, String vdesc) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vdesc = vdesc;
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

	public String getVdesc() {
		return vdesc;
	}

	public void setVdesc(String vdesc) {
		this.vdesc = vdesc;
	}
	@Override
	public String toString() {
		return this.vname;
	}

}
