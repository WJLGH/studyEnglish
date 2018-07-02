package model;

public class MeaningBean {
	private int cid;
	private String chinese;
	private int wid;
	
	public MeaningBean() {
		
	}

	public MeaningBean(int cid, String chinese, int wid) {
		super();
		this.cid = cid;
		this.chinese = chinese;
		this.wid = wid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	@Override
	public String toString() {
		return "MeaningBean [cid=" + cid + ", chinese=" + chinese + ", wid=" + wid + "]";
	}
	
	
}
