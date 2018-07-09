package com.baidu.translate.demo;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TransApi {
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    private String appid;
    private String securityKey;
    /**
     * 设置百度所给开发者的 id和 秘钥
     * @param appid
     * @param securityKey
     */
    public TransApi(String appid, String securityKey) {
        this.appid = appid;
        this.securityKey = securityKey;
    }
    
    /**
     * 把指定语言的字符串翻译为指定语言
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
     * 获得所要发送的url中的参数
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

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 获得唯一签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }

}
