package twindy.common.cache;


import twindy.common.cache.ehcache.Ehcache;

/**
 * 缓存器
 * @author senola
 * @time 2017-06-30
 */
public abstract class Cache {
    private static Ehcache defaultEhcache;

    /**
     * 系统默认公共缓存
     * @return the defaultEhcache the cache is "default"
     */
    public static Ehcache getDefaultEhcache() {
        if (defaultEhcache == null) {
            defaultEhcache = new Ehcache("common");
        }

        return defaultEhcache;
    }
}
