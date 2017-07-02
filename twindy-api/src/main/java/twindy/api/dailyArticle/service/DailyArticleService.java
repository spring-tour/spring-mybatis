package twindy.api.dailyArticle.service;

import twindy.api.dailyArticle.entity.DailyArticle;

/**
 * something describe this js file.
 *
 * @author 潭风
 * @time 2017-07-02
 */
public interface DailyArticleService {
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
