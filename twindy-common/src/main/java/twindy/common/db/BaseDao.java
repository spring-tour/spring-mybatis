package twindy.common.db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;

/**
 * Dao的基类
 * @author senola
 * @time 2017-06-29
 */
public class BaseDao extends SqlSessionDaoSupport {

    /**
     * mybatis取消了自动注入SqlSessionFactory 和 SqlSessionTemplate
     */
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
