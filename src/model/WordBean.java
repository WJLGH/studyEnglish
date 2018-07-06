package model;

import java.util.List;

public class WordBean {
	private int wid;
	private String word;
	private String eg;
	private String trans;
	private int vid;
	private List<MeaningBean> means;

	public WordBean() {

	}
	
	public WordBean(int wid, String word, String eg, String trans, int vid, List<MeaningBean> means) {
		super();
		this.wid = wid;
		this.word = word;
		this.eg = eg;
		this.trans = trans;
		this.vid = vid;
		this.means = means;
	}

	public WordBean(String word, String eg, String trans, int vid) {
		super();
		this.word = word;
		this.eg = eg;
		this.trans = trans;
		this.vid = vid;
	}

	public WordBean(int wid, String word, String eg, String trans, int vid) {
		this.wid = wid;
		this.word = word;
		this.eg = eg;
		this.trans = trans;
		this.vid = vid;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getEg() {
		return eg;
	}

	public void setEg(String eg) {
		this.eg = eg;
	}

	public String getTrans() {
		return trans;
	}

	public void setTrans(String trans) {
		this.trans = trans;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public List<MeaningBean> getMeans() {
		return means;
	}

	public void setMeans(List<MeaningBean> means) {
		this.means = means;
	}

	@Override
	public String toString() {
		return "WordBean [wid=" + wid + ", word=" + word + ", eg=" + eg + ", trans=" + trans + ", vid=" + vid
				+ ", means=" + means + "]";
	}

}
