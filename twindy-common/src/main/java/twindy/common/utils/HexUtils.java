package twindy.common.utils;

/**
 * 描述：
 * @author twindy
 * @time 2017-04-20
 */
public class HexUtils {

    /**
     *  Convert byte array to hex string
     */
    public static String toHex(byte[] bytes){
        StringBuffer sb = new StringBuffer(bytes.length * 3);
        for (int i = 0; i < bytes.length; i++) {
            int val = ((int) bytes[i]) & 0xff;
            if (val < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }

        return sb.toString();
    }

    /**
     * Convert hex string to byte array
     * @param str
     * @return
     */
    public static byte[] hexToBytes(String str){
        int l = str.length();
        if ((l % 2) != 0) {
            throw new IllegalArgumentException("长度不是偶数!");
        }
        byte[] bytes = new byte[l/2];
        for(int i=0;i<l;i=i+2){
            String item = str.substring(i, i+2);
            bytes[i/2] = (byte)Integer.parseInt(item, 16);
        }
        return bytes;
    }
}
