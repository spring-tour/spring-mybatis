package twindy.common.utils.encrypt;

import twindy.common.utils.HexUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * 描述：简单的AES加密方式
 *
 * @author twindy
 * @time 2017-04-18
 */
public class AESUtils {

    private static final String Algorithm = "AES";
    private static final String DEFAULT_KEY = "ADdu!0#sdj%(&9dgfyLOVEHYABBYSTWINDYORGDnduH345$^32<>^&())hhlsav";

    /**
     * 加密
     * @param plainText
     * @return
     */
    public static String encrypt(String plainText){
        return encrypt(plainText, DEFAULT_KEY);
    }

    /**
     * 加密
     * @param plainText 明文
     * @param pwd 16位的随机码
     * @return
     */
    public static String encrypt(String plainText, String pwd) {
        try{
            return HexUtils.toHex(encrypt(plainText.getBytes("UTF-8"), pwd));
        }catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * the password for decrypt read from config file ,config file key is AES.passowrd
     */
    public static String decrypt(String cipherText){
        return decrypt(cipherText, DEFAULT_KEY);
    }

    /**
     * 解密 以String密文输入,String明文输出
     * @param pwd
     * @return
     */
    public static String decrypt(String cipherText, String pwd) {
        try{
            byte[] bytes = decrypt(HexUtils.hexToBytes(cipherText), pwd);
            return new String(bytes,"UTF-8");
        }catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加密以byte[]明文输入,byte[]密文输出
     * @param byteS
     * @return
     */
    public static byte[] encrypt(byte[] byteS,String pwd) {

        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance(Algorithm);
            SecretKeySpec keySpec = new SecretKeySpec(getKey(pwd), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byteFina = cipher.doFinal(byteS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * 解密以byte[]密文输入,以byte[]明文输出
     * @param byteD
     * @return
     */
    public static byte[] decrypt(byte[] byteD,String pwd) {
        Cipher cipher;
        byte[] byteFina = null;
        try {
            cipher = Cipher.getInstance(Algorithm);
            SecretKeySpec keySpec = new SecretKeySpec(getKey(pwd), "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byteFina = cipher.doFinal(byteD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    private static byte[] getKey(String password) throws UnsupportedEncodingException{
        // 使用256位密码
        if(password.length() > 16)
            password = password.substring(0, 16);
        else if(password.length() < 16){
            int count = (16 - password.length());
            for(int i=0;i<count;i++){
                password+="0";
            }
        }
        return password.getBytes("UTF-8");
    }
}
