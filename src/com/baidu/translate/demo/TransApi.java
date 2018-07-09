package com.baidu.translate.demo;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TransApi {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private String appid;
    private String securityKey;
    /**
     * ���ðٶ����������ߵ� id�� ��Կ
     * @param appid
     * @param securityKey
     */
    public TransApi(String appid, String securityKey) {
        this.appid = appid;
        this.securityKey = securityKey;
    }
    
    /**
     * ��ָ�����Ե��ַ�������Ϊָ������
     * @param query
     * @param from
     * @param to
     * @return
     */
    public String getTransResult(String query, String from, String to)  {
        Map<String, String> params = null;
		try {
			params = buildParams(query, from, to);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return HttpGet.get(TRANS_API_HOST, params);
    }
    /**
     * �����Ҫ���͵�url�еĲ���
     * @param query
     * @param from
     * @param to
     * @return
     * @throws UnsupportedEncodingException
     */
    private Map<String, String> buildParams(String query, String from, String to) throws UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);

        params.put("appid", appid);

        // �����
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // ���Ψһǩ��
        String src = appid + query + salt + securityKey; // ����ǰ��ԭ��
        params.put("sign", MD5.md5(src));

        return params;
    }

}
