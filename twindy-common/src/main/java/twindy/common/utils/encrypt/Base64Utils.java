package twindy.common.utils.encrypt;

import org.apache.commons.codec.binary.Base64;

/**
 * 描述：Base64加解密
 *
 * @author twindy
 * @time 2017-04-18
 */
public class Base64Utils {

    /**
     * Base64加密
     * @param code
     * @return
     */
    public static String encode(String code) {
        return encode(code.getBytes());
    }

    /**
     * Base64加密
     * @param code
     * @return
     */
    public static String encode(byte[] code) {
        return Base64.encodeBase64String(code);
    }

    /**
     * Base64解密密
     * @param code
     * @return
     */
    public static String decode(String code) {
        byte[] b = Base64.decodeBase64(code.getBytes());
        return new String(b);
    }
}
