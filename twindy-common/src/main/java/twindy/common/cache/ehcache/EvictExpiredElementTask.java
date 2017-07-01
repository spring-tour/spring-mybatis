package twindy.common.cache.ehcache;

import net.sf.ehcache.Cache;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.TimerTask;

public class EvictExpiredElementTask extends TimerTask {
	private static final Log log = LogFactory.getLog(EvictExpiredElementTask.class);
	private Cache cache;

	public EvictExpiredElementTask(Cache cache) {
		this.cache = cache;
	}
	
	@Override
	public void run() {
		log.info("evict ehcache cache space[" +  cache.getName()+ "] expired elements, evict before:{" + cache.getSize()+"}");
		cache.evictExpiredElements();
		log.info("evict ehcache cache space[{" + cache.getName() +"}] expired elements, evict after:{" + cache.getSize() + "}");
	}
}
