package twindy.api.ipCrawl.dao;

import twindy.api.ipCrawl.entity.ProxyIp;

import java.util.List;

/**
 * ProxyIpDao
 *
 * @author 潭风
 * @time 2017-07-10
 */
public interface ProxyIpDao {
    int addProxyIp(ProxyIp proxyIp);
    List<ProxyIp> queryProxyIpList();
    int deleteProxyIp(long id);
    int updateProxyIp(ProxyIp proxyIp);
}
