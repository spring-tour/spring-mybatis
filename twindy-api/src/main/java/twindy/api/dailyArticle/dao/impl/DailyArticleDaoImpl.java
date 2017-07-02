package twindy.api.dailyArticle.dao.impl;

import org.springframework.stereotype.Repository;
import twindy.api.dailyArticle.dao.DailyArticleDao;
import twindy.api.dailyArticle.entity.DailyArticle;
import twindy.common.db.BaseDao;

/**
 * something describe this js file.
 *
 * @author 潭风
 * @time 2017-07-02
 */
@Repository
public class DailyArticleDaoImpl extends BaseDao implements DailyArticleDao {

    @Override
    public int addDailyArticle(DailyArticle dailyArticle) {
        return getSqlSession().insert("dailyArticle.addDailyArticle", dailyArticle);
    }

    @Override
    public DailyArticle queryDailyArticle() {
        return getSqlSession().selectOne("dailyArticle.queryDailyArticle");
    }
}
