package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.CollectDao;
import dao.WordDao;
import model.CollectBean;
import model.MeaningBean;
import model.UserBean;
import model.WordBean;
import util.CharacterUtil;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ReviewWordView extends JInternalFrame {
	private static Random random = new Random();
	public static int size = 4;
	private JButton[] options;
	private UserBean user;
	private List<WordBean> list;
	private int cnt;
	private int nIndex;
	private boolean[] isPass;
	private int pCnt = 0;
	private JButton nowPosition;
	private JLabel englishLabel;

	public ReviewWordView(UserBean user) {
		setIconifiable(true);
		setClosable(true);
		this.user = user;
		getList();
		if (list != null) {
			cnt = list.size();
			pCnt = 0;
			isPass = new boolean[cnt];
			for (int i = 0; i < cnt; i++) {
				isPass[i] = false;
			}
		}
		setBounds(100, 100, 772, 700);
		getContentPane().setLayout(null);

		englishLabel = new JLabel("New label");
		englishLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 30));
		englishLabel.setBounds(135, 77, 172, 79);
		getContentPane().add(englishLabel);

		options = new JButton[size];
		for (int i = 0; i < size; i++) {
			options[i] = new JButton("");
			options[i].setBounds(135, 243 + i * 102, 451, 60);
			options[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setNextShowWord(e);
				}
			});
			getContentPane().add(options[i]);
		}

		setVisible(true);
		setNextShowWord(null);
	}
	/**
	 * 得到复习的单词表
	 * @return
	 */
	private boolean getList() {
		int n = user.getUpage();
		/**
		 * 没有足够的单词复习
		 */
		if(n<WordDao.pageSize) {
			JOptionPane.showMessageDialog(null, "请先背诵单词");
			this.dispose();
			return false;
		}
		/**
		 * 获得背诵过的单词
		 */
		try {
			list = WordDao.limitQuery(user.getUpage()-WordDao.pageSize);
			System.out.println("数据库数据为：");
			for (WordBean wordBean : list) {
				System.out.println(wordBean.getMeans());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * 判断是否选对选项
	 * @param e
	 * @return
	 */
	public boolean judge(ActionEvent e) {
		if (e == null) {
			return false;
		}
		System.out.println("点击" + e.getSource().hashCode());
		System.out.println("正确" + nowPosition.hashCode());
		return e.getSource() == nowPosition;
	}

	public void setList(List<WordBean> list) {
		this.list = list;
	}
	/**
	 * 复习结束条件判断
	 * @return
	 */
	public boolean isFinish() {
		return cnt == pCnt;
	}
	/**
	 * 得到下一个为复习过的或者复习过但错了的单词
	 * @return
	 */
	public WordBean getNext() {
		if (isFinish() || list == null) {
			System.out.println("isFinish");
			this.dispose();
			return null;
		}
		nIndex = (nIndex + 1) % cnt;
		while (isPass[nIndex]) {
			nIndex = (nIndex + 1) % cnt;
		}
		WordBean wordBean = list.get(nIndex);
		return wordBean;
	}
	/**
	 * 获得一个从0 - cnt 的所有整数中的出nIndex 的三个数
	 * @param cnt
	 * @param nIndex
	 * @return
	 */
	public int[] getThreeRandomIndex(int cnt, int nIndex) {
		int[] result = new int[3];
		int n = 0;
		while (n < 3) {
			int r = random.nextInt(cnt);
			boolean have = false;
			for (int i = 0; i < n; i++) {
				if (r == nIndex || r == result[i]) {
					have = true;
					break;
				}
			}
			if (!have && r != nIndex) {
				result[n++] = r;
			}
		}
		return result;
	}
	/**
	 * 单词的释义变成字符串
	 * @param wb
	 * @return
	 */
	public String meaingListToString(WordBean wb) {
		StringBuffer sb = new StringBuffer();
		for (MeaningBean mb : wb.getMeans()) {
			sb.append(mb.getChinese() + ";");
		}
		return sb.toString();
	}
	/**
	 * 设置下一个显示的单词
	 * @param e
	 */
	public void setNextShowWord(ActionEvent e) {
		/**
		 * 判断选择并设置状态
		 */
		judgeAndSet(e);
		System.out.println("总个数" + cnt + "过的个数" + pCnt);
		System.out.println("当前id" + nIndex);
		System.out.println("单词状态" + Arrays.toString(isPass));
		/**
		 * 重置选项
		 */
		resetOptions();
		/**
		 * 设置正确选项
		 */
		System.out.println("设置正确选项值");
		WordBean wb = getNext();
		System.out.println("正在显示现在的:" + nIndex);
		if (wb == null) {
			dispose();
			return;
		}
		JButton nwb = getRandomEmptyButton();
		this.englishLabel.setText(wb.getWord());
		nwb.setText(meaingListToString(wb));
		nowPosition = nwb;

		System.out.println("设置干扰选项值");
		int[] indexs = getThreeRandomIndex(cnt, nIndex);
		System.out.println("干扰序号" + Arrays.toString(indexs));
		for (int i : indexs) {
			JButton button = getRandomEmptyButton();
			button.setText(meaingListToString(list.get(i)));
		}
		System.out.println("----------一次事件--------------------");
	}
	/**
	 * 判断并设置状态
	 * @param e
	 */
	private void judgeAndSet(ActionEvent e) {
		System.out.println("正在判断的:" + nIndex);
		if (judge(e)) {
			pCnt++;
			System.out.println("选对了,现在个数为" + pCnt);
			isPass[nIndex] = true;
			if (pCnt == cnt) {
				System.out.println("背完");
				return;
			}
		} else {
			System.out.println("错了");
		}
	}

	public static void main(String[] args) {
		new ReviewWordView(new UserBean("123", "123"));
	}
	/**
	 * 把按钮上的选项清空
	 */
	private void resetOptions() {
		for (JButton jButton : options) {
			jButton.setText("");
		}
	}
	/**
	 * 得到一个随机的空按钮
	 * @return
	 */
	private JButton getRandomEmptyButton() {
		while (true) {
			int index = random.nextInt(size);
			String s = options[index].getText();
			if (CharacterUtil.isEmpty(s)) {
				return options[index];
			}
		}
	}
}
