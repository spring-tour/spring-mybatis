package twindy.api.ipCrawl.entity;

import java.util.Date;

/**
 * 代理IP实体类
 * @author 潭风
 * @time 2017-07-10
 */
public class ProxyIp {
    private long id;
    private String ipAddress; // ip地址
    private int port; // ip地址对应的端口
    private String serverAddress;
    private int httpType; // http类型： 0：http, 1: https
    private long responseTime; // 响应时间（ms）
    private int proxyType; // 代理类型：0：其他，1： 国内代理， 2： 国外代理
    private int status; // 状态：0:正常（默认），-1：不正常
    private Date createTime; // 创建时间
    private Date updateTime; // 更新时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getHttpType() {
        return httpType;
    }

    public void setHttpType(int httpType) {
        this.httpType = httpType;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public int getProxyType() {
        return proxyType;
    }

    public void setProxyType(int proxyType) {
        this.proxyType = proxyType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
