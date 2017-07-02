package twindy.api.dailyArticle.dao;

import twindy.api.dailyArticle.entity.DailyArticle;

/**
 * 每日一文
 * @author 潭风
 * @time 2017-07-02
 */
public interface DailyArticleDao {
    /**
     * 查询记录
     * @return dailyArticle
     */
    DailyArticle queryDailyArticle();

    /**
     * 添加文章
     * @param dailyArticle dailyArticle
     * @return dailyArticle
     */
    int addDailyArticle(DailyArticle dailyArticle);
}