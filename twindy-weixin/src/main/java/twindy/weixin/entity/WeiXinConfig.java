package twindy.weixin.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 微信公众号相关配置
 * @author senola
 * @time 2017-07-04
 */
@Configuration
public class WeiXinConfig {

    @Value("#{weixinProperties.wx_appId}")
    private String appId; // 公众号appID

    @Value("#{weixinProperties.wx_appsecret}")
    private String appsecret; // 公众号密钥

    @Value("#{weixinProperties.wx_token}")
    private String token; // 公众号token

    @Value("#{weixinProperties.wx_aeskey}")
    private String aesKey; // 公众号加密密钥

    public String getAppId() {
        return appId;
    }
    public String getAppsecret() {
        return appsecret;
    }
    public String getToken() {
        return token;
    }
    public String getAesKey() {
        return aesKey;
    }
}
