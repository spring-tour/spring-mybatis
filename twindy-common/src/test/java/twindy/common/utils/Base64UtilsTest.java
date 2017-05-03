package twindy.common.utils;

import org.junit.Assert;
import org.junit.Test;
import twindy.common.utils.encrypt.AESUtils;
import twindy.common.utils.encrypt.Base64Utils;

/**
 *
 * @author twindy
 * @time 2017-04-20
 */
public class Base64UtilsTest {

    @Test
    public void base64EncodeString(){
        String willEncodeString = "hello world";
        String expected = "aGVsbG8gd29ybGQ=";
        Assert.assertEquals(expected, Base64Utils.encode(willEncodeString));
    }

    @Test
    public void base64decodeString(){
        String willDecodeString = "aGVsbG8gd29ybGQ=";
        String expected = "hello world";
        //System.out.println(AESUtils.encrypt("@Twindyorg6!.#"));
        //System.out.print(AESUtils.decrypt("d9641dee97d9d28416176d4519313aa5"));
        Assert.assertEquals(expected, Base64Utils.decode(willDecodeString));
    }
}
