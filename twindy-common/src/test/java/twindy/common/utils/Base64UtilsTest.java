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
        Assert.assertEquals(expected, Base64Utils.decode(willDecodeString));
    }
}
