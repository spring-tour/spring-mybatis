package twindy.api.ipCrawl.dao.impl;

import org.springframework.stereotype.Repository;
import twindy.api.ipCrawl.dao.ProxyIpDao;
import twindy.api.ipCrawl.entity.ProxyIp;
import twindy.common.db.BaseDao;

import java.util.List;

/**
 * something describe this js file.
 *
 * @author 潭风
 * @time 2017-07-10
 */
@Repository
public class ProxyIpDaoImpl extends BaseDao implements ProxyIpDao{

    @Override
    public int addProxyIp(ProxyIp proxyIp) {
        return getSqlSession().insert("proxyIp.addProxyIp", proxyIp);
    }

    @Override
    public List<ProxyIp> queryProxyIpList() {
        return getSqlSession().selectList("proxyIp.queryProxyIpList");
    }

    @Override
    public int deleteProxyIp(long id) {
        return getSqlSession().delete("proxyIp.deleteProxyIp", id);
    }

    @Override
    public int updateProxyIp(ProxyIp proxyIp) {
        return getSqlSession().update("proxyIp.updateProxyIp", proxyIp);
    }
}
