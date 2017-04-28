package twindy.common.utils;

import java.util.UUID;

/**
 * @author senola
 * @time 2017-04-26
 */
public class UUIDUtils {

    /**
     * 通过UUID生成唯一ID, 替换 “-”
     * @return
     */
     public static String randomUUID() {
         return UUID.randomUUID().toString().replaceAll("-", "s");
     }
}
