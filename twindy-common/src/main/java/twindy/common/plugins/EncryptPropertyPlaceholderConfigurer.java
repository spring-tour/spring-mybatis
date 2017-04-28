package twindy.common.plugins;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import twindy.common.utils.encrypt.AESUtils;

/**
 * 支持加密配置文件插件
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] propertyNames = {
		"jdbc.password", "slave.jdbc.password", "generator.jdbc.password", "master.redis.password"
	};

	/**
	 * 解密指定propertyName的加密属性值
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
				return AESUtils.decrypt(propertyValue);
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}

}
