package control;

import java.util.LinkedList;

import model.UserBean;
import model.WordBean;

public class ReciteWords {
	private UserBean user;
	private LinkedList<WordBean> list; 
	public WordBean getNext() {
		return null;
	}
	public int getSize() {
		return 0;
	}
	public void delet(WordBean word) {
		list.remove(word);
	}
	public void addUsetCollect() {
		
	}
	public void save() {
		
	}
}
