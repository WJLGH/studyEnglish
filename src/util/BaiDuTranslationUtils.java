package util;

import com.baidu.translate.demo.TransApi;

import net.sf.json.JSONObject;

public class BaiDuTranslationUtils {

	// http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
	// �ٶ��ṩ�������ߵ�API��Կ
	private static final String APP_ID = "20180701000181819";
	private static final String SECURITY_KEY = "h108F01mZ70v7WNFvySg";

	/**
	 * ��װ���İٶȷ���API�ӿ�
	 * "en","zh"
	 * @param query
	 * @param targetLanguage
	 * @return
	 */
	public static String tranlate(String query, String targetLanguage) {
		TransApi api = new TransApi(APP_ID, SECURITY_KEY);
		String jsonString = api.getTransResult(query, "auto", targetLanguage);
		// System.out.println(jsonString);
		if (jsonString.startsWith("{\"error")) {
			return CharacterUtil.ERROR;
		}

		JSONObject message = JSONObject.fromObject(jsonString);

		String resultString = message.get("trans_result").toString();
		resultString = resultString.replace("[", "");
		resultString = resultString.replace("]", "");
		JSONObject transResult = JSONObject.fromObject(resultString);
		return transResult.get("dst").toString();
	}

	public static void main(String[] args) {
		System.out.println("-------------");
		System.out.println(tranlate("Ӣ��", "en"));
		System.out.println(tranlate("big", "zh"));
		System.out.println(tranlate("", "en"));
	}

}
