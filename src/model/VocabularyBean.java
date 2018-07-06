package model;

import java.util.List;

public class VocabularyBean {
	private int vid;

	private String vname;
	private String vdesc;

	public VocabularyBean() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VocabularyBean other = (VocabularyBean) obj;
		if (vid != other.vid)
			return false;
		return true;
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
