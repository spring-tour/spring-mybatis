package twindy.api.ipCrawl.service;

import twindy.api.ipCrawl.entity.ProxyIp;

import java.util.List;

/**
 * 代理IP相关服务类
 *
 * @author 潭风
 * @time 2017-07-10
 */
public interface ProxyIpService {
    int addProxyIp(ProxyIp proxyIp);
    List<ProxyIp> queryProxyIpList();
    int deleteProxyIp(long id);
    int updateProxyIp(ProxyIp proxyIp);
}
