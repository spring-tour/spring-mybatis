package twindy.api.ipCrawl.service.impl;

import org.springframework.stereotype.Service;
import twindy.api.ipCrawl.dao.ProxyIpDao;
import twindy.api.ipCrawl.entity.ProxyIp;
import twindy.api.ipCrawl.service.ProxyIpService;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author 潭风
 * @time 2017-07-10
 */
@Service
public class ProxyIpServiceImpl implements ProxyIpService {

    @Resource
    private ProxyIpDao proxyIpDao;

    @Override
    public int addProxyIp(ProxyIp proxyIp) {
        return proxyIpDao.addProxyIp(proxyIp);
    }

    @Override
    public List<ProxyIp> queryProxyIpList() {
        return proxyIpDao.queryProxyIpList();
    }

    @Override
    public int deleteProxyIp(long id) {
        return proxyIpDao.deleteProxyIp(id);
    }

    @Override
    public int updateProxyIp(ProxyIp proxyIp) {
        return proxyIpDao.updateProxyIp(proxyIp);
    }
}
