package com.wg.common.decrypt;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 文歌 on 2017/7/22.
 */
public class httpTest {
    public static void main(String[] arg) {
        Map<String,String> req = new HashMap<String, String>();
        req.put("merchantId","M0000000601");
        req.put("userId","10000013215");
        req.put("sumAmount","12000");
        req.put("rpAmount","0");
        req.put("cardAmount","0");
        req.put("outOrderId","20170626MS0000000000021100021042");
        req.put("tranSerialNo","01234567892017062601");
        req.put("tranTime","2017-06-26 16:50:00");
        req.put("currType","CNY");
        req.put("orderStatus","00");
        req.put("cardNo","1234567789990");
        String sign_string  = AES.getSignDataStr("sign",req)+"&key=abcd1234efghklaaaajjjj";
        String mysign = DigestUtils.md5Hex(sign_string.getBytes());
        req.put("sign", mysign.toUpperCase());//签名结果 加入请求提交参数组中
        /**AES加密*/
        String mapString = req.toString();
        String encryptStr = AES.aesEncrypt(mapString,"abcd1234efghklaaaajjjj");
        /**AES解密*/
        //String encryptStr = "lfHjZ2O2Cb3X5s6GO5i4B8SYHwN8HJ2thH2WEOtyzuT0gmvuykm6YHxf7P5p7MGeRmynEsffaeYu\nQS77HyGKMxUXvQbnTel6btcNGghGhEdaobCUhAHV8mjd8YwqUsvEO2L+h8OePKkprwvm7wc132ma\na11/MkvEtmCWUOktobDWp21G+Fi8Hesw+5Bph3iUWvzsCx8h3Oa+yCXXxw3BeqckF6XUdphZMxDw\nEStE+nV0o/1JO06mLqPDN72WQv7dIbBm7SzQ1Q7xHm+mhtWwl/mynvr8nhclxRNkMI+xRHpjDu9l\nskzADpacjHgfUOWkYDdOE9MBZeCpEtbxj/5t0wwrMyOhn1+LdSj+m3X1/G0jkKNvb43yudvzNgc6\nT30PMONoEcaKxsMCcFT9ngXOIrORBktu29WKNIWJp/sVXKy8hQWvz0CvWcUga1GHsD9WEHBLS2gP\naswoKMhou/2bvlaovYMjQGqB/XTtRtxTbm6ktMaTfuz5sz5nkPQtqwRIRNdhrfB9mGz6JA3EyvQ1\nr+QJvG5Jur+hq3kKvXWKKymOXL16PZtxp1YwLoMGVotYEO731ZRS2QiGgINqwWyK0dIK9cmLsjYw\noyH8FrvQN50\n";

        String decryptData = AES.aesDecrypt(encryptStr,"abcd1234efghklaaaajjjj","utf-8");//解密
        Map<String,String> resultMap = new HashMap<String, String>();
        String[]  result= decryptData.split("&");
        if (result.length > 0) {
            for (String m:result) {
                String[] s = m.split("=");
                resultMap.put(s[0],s[1]);
            }
        }
        //验签
        String sign  = AES.getSignDataStr("sign",resultMap)+"&key=abcd1234";
        sign = DigestUtils.md5Hex(sign.getBytes());
        if (!StringUtils.equals(sign.toUpperCase(),resultMap.get("sign"))) {
            System.out.print("验签失败");
        }
    }
}
