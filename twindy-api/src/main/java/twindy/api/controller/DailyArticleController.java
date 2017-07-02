package twindy.api.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import twindy.api.dailyArticle.entity.DailyArticle;
import twindy.api.dailyArticle.service.DailyArticleService;
import twindy.common.cache.Cache;
import twindy.common.http.HttpClientUtils;
import twindy.common.utils.DateUtils;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 每日一文控制器
 * @author 潭风
 * @time 2017-07-02
 */
@Controller
@RequestMapping("/articles")
public class DailyArticleController {

    @Resource
    private DailyArticleService dailyArticleService;
    private static final String DAILY_ARTICLE_URL = "https://interface.meiriyiwen.com/article/today?dev=1";
    private static final String DAILY_ARTICLE_DATE_URL = "https://interface.meiriyiwen.com/article/day?dev=1&date=";
    private static final String RANDROM_DAILY_ARTICLE_URL = "https://interface.meiriyiwen.com/article/random?dev=1";
    private static final String DAILY_ARTICLE_CACHE_KEY = "articles_dailyArticle";
    private static final int CACHE_TIME = 86400; // 缓存一天时间
    private static final Log log = LogFactory.getLog(DailyArticleController.class);


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void addArticles() {
        for(int i = -1000; i > -1500; i--) {
            Date nowTime = new Date();
            Date queryDate = DateUtils.getDay(nowTime, i);
            String url = DAILY_ARTICLE_DATE_URL + DateUtils.formatDate(queryDate, "yyyyMMdd");
            log.info("[ " + i + "]  ==>" + url);
            try {
                Thread.sleep(2000);
                this.addArticle(url, queryDate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private JSONObject addArticle(String url, Date queryDate) {
        try {
            String result = HttpClientUtils.get(url);
            if(result != null) {
                JSONObject object = JSONObject.parseObject(result);
                JSONObject dailyArticleJson = (JSONObject) object.get("data");
                DailyArticle dailyArticle = new DailyArticle();
                dailyArticle.setTitle(dailyArticleJson.get("title").toString());
                dailyArticle.setAuthor(dailyArticleJson.get("author").toString());
                dailyArticle.setContent(dailyArticleJson.get("content").toString());
                dailyArticle.setFirstParagraph(dailyArticleJson.get("digest").toString());
                dailyArticle.setCreateTime(queryDate);
                dailyArticle.setUpdateTime(queryDate);
                dailyArticleService.addDailyArticle(dailyArticle);
                return object;
            }
        } catch (Exception e) {
            log.error("操作失败：", e);
        }
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public JSONObject queryArticle() {
        DailyArticle dailyArticle = Cache.getDefaultEhcache().get(DAILY_ARTICLE_CACHE_KEY);
        if(dailyArticle == null) {
            dailyArticle = dailyArticleService.queryDailyArticle();
            Cache.getDefaultEhcache().add(DAILY_ARTICLE_CACHE_KEY, dailyArticle, null, CACHE_TIME);
        }
        // 如果当前时间和最新文章时间相差一天，则取服务器抓取最新文章
        if(DateUtils.differDay(dailyArticle.getCreateTime(), new Date()) > 1) {
            return this.addArticle(DAILY_ARTICLE_URL, new Date());
        }
        return dailyArticle.toJSON();
    }
}
