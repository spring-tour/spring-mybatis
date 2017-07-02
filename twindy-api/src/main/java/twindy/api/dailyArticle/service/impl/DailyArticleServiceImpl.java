package twindy.api.dailyArticle.service.impl;

import org.springframework.stereotype.Service;
import twindy.api.dailyArticle.dao.DailyArticleDao;
import twindy.api.dailyArticle.entity.DailyArticle;
import twindy.api.dailyArticle.service.DailyArticleService;

import javax.annotation.Resource;

/**
 * something describe this js file.
 *
 * @author 潭风
 * @time 2017-07-02
 */
@Service
public class DailyArticleServiceImpl implements DailyArticleService {

    @Resource
    private DailyArticleDao dailyArticleDao;

    @Override
    public DailyArticle queryDailyArticle() {
        return dailyArticleDao.queryDailyArticle();
    }

    @Override
    public int addDailyArticle(DailyArticle dailyArticle) {
        return dailyArticleDao.addDailyArticle(dailyArticle);
    }
}
