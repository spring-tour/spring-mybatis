package twindy.common.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Date;
import java.util.List;

/**
 * 用法：Cache.getDefaultEhcache().add(cacheKey, info, null, 24 * 60 * 60); // 默认缓存24小时
 * @author senola
 * @time 2017-06-30
 */
public class Ehcache {

    private Cache cache;
    private static CacheManager cacheManager = new CacheManager(net.sf.ehcache.Ehcache.class.getResourceAsStream("/ehcache.xml"));
    private static final Log log = LogFactory.getLog(Ehcache.class);

    public Ehcache(String cacheName) {
        cache = cacheManager.getCache(cacheName);
    }

    /**
     * 添加缓存
     * @param key 缓存唯一键
     * @param value 需要缓存的对象
     * @param timeToIdleSeconds 缓存对象空闲多少秒后删除，null表示不设置
     * @param timeToLiveSeconds 缓存对象存活多少秒后删除，null表示不设置
     */
    public void add(String key, Object value, Integer timeToIdleSeconds, Integer timeToLiveSeconds) {
        if (timeToIdleSeconds == null && timeToLiveSeconds == null) {
            throw new IllegalArgumentException("过期时间不能都为空!");
        }

        timeToIdleSeconds = timeToIdleSeconds==null?0:timeToIdleSeconds;
        timeToLiveSeconds = timeToLiveSeconds==null?0:timeToLiveSeconds;

        Element element = new Element(key, value, false, timeToIdleSeconds, timeToLiveSeconds);
        cache.put(element);
    }

    /**
     * 添加缓存
     * @param key 缓存唯一键
     * @param value 需要缓存的对象
     * @param date 设置1个具体的过期时间
     */
    public void add(String key, Object value, Date date) {
        if(date == null) {
            throw new IllegalArgumentException("过期时间不能为空!");
        }

        Date curDate = new Date();
        if(date.compareTo(curDate) <= 0) {
            throw new IllegalArgumentException("过期时间不能小于等于当前时间!");
        }

        Long millSeconde = date.getTime() - curDate.getTime();
        Long second = (millSeconde / 1000);
        this.add(key, value, 0, second.intValue());
    }

    /**
     * 获取缓存
     * @param key 缓存唯一键
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        Element element = cache.get(key);
        if(element == null) {
            return null;
        }

        return (T) element.getObjectValue();
    }

    /**
     * 删除缓存
     * @param key 缓存唯一键
     */
    public void remove(String key) {
        try{
            cache.remove(key);
        }catch(IllegalStateException ex){
            // 如果缓存状态不正确，不报错
            log.warn(ex.getMessage(), ex);
        }
    }

    /**
     * 清除所有缓存
     */
    public void clear() {
        List<?> keys = cache.getKeys();
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            remove(key);
        }
    }

    /**
     * 重置缓存对象存活时间
     * @param key 缓存唯一键
     * @param timeToLiveSeconds 缓存对象存活多少秒后删除，null表示不设置
     */
    public void setTimeToLive(String key, int timeToLiveSeconds){
        Element element = cache.get(key);
        if(element != null) element.setTimeToLive(timeToLiveSeconds);
    }

    public Cache getCache(){
        return cache;
    }


    public long getMemoryStoreSize(){
        return cache.getMemoryStoreSize();
    }
    public long getDiskStoreSize(){
        return cache.getDiskStoreSize();
    }
    public long getSize(){
        return cache.getSize();
    }
    public void evictExpiredElements(){
        cache.evictExpiredElements();
    }
    public List<?> getKeys(){
        return cache.getKeys();
    }
}
