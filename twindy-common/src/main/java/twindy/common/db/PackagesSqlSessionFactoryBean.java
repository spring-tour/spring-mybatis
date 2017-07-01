package twindy.common.db;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 由于mybatis自带的SqlSessionFactoryBean类在配置typeAliasesPackage时候不支持通配符
 * 所以写了setTypeAliasesPackage方法
 * @time 2017-06-29
 */
public class PackagesSqlSessionFactoryBean extends SqlSessionFactoryBean {
    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
    private static final Log log = LogFactory.getLog(PackagesSqlSessionFactoryBean.class);

    @Override
    public void setTypeAliasesPackage(String packagePth) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resolver);
        String typeAliasesPackage = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                ClassUtils.convertClassNameToResourcePath(packagePth) + "/" + DEFAULT_RESOURCE_PATTERN;

        //将加载多个绝对匹配的所有Resource
        //将首先通过ClassLoader.getResource("META-INF")加载非模式路径部分
        //然后进行遍历模式匹配
        try {
            List<String> result = new ArrayList<>();
            Resource[] resources = resolver.getResources(typeAliasesPackage);
            if (resources != null && resources.length > 0) {
                MetadataReader metadataReader;
                for (Resource resource : resources) {
                    if (resource.isReadable()) {
                        metadataReader = metadataReaderFactory.getMetadataReader(resource);
                        try {
                            result.add(Class.forName(metadataReader.getClassMetadata().getClassName()).getPackage().getName());
                        } catch (ClassNotFoundException e) {
                            log.error("扫描包异常", e);
                        }
                    }
                }
            }
            if (!result.isEmpty()) {
                super.setTypeAliasesPackage(StringUtils.join(result.toArray(), ","));
            } else {
                log.warn("参数typeAliasesPackage:" + typeAliasesPackage + "，未找到任何包");
            }
        } catch (IOException e) {
            log.error("扫描包异常", e);
        }
    }
}
