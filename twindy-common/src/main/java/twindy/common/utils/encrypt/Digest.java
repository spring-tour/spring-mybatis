package twindy.common.utils.encrypt;

import twindy.common.utils.HexUtils;

import java.security.MessageDigest;

/**
 * 描述：非对称加密（MD5、SHA）
 *
 * @author twindy
 * @time 2017-04-20
 */
public class Digest {
    public static String MD5(String text){
        return getHexMessageDigest(text, "MD5");
    }

    public static String SHA(String text){
        return getHexMessageDigest(text, "SHA");
    }

    public static byte[] MD5Bytes(String text){
        return getMessageDigest(text,"MD5");
    }

    public static byte[] getMessageDigest(String text,String algorithm){
        try{
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(text.getBytes("UTF-8"));
            byte[] bytes = md.digest();
            return bytes;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getHexMessageDigest(String text,String algorithm){
        return HexUtils.toHex(getMessageDigest(text, algorithm));
    }
}
