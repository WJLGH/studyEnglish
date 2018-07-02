import java.io.UnsupportedEncodingException;

import com.baidu.translate.demo.TransApi;

public class TestBaiDuTranslate {

    //  http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20180701000181819";
    private static final String SECURITY_KEY = "h108F01mZ70v7WNFvySg";

    public static void main(String[] args) throws UnsupportedEncodingException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "Œ“ «À≠";
        String re = api.getTransResult(query, "auto", "en");
        int e = re.lastIndexOf("\"");
        int b = re.lastIndexOf(":");
        String yw = re.substring(b+2, e);
        System.out.println(re);
        System.out.println(yw);
    }

}
