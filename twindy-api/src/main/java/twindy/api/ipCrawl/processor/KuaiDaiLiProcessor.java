package twindy.api.ipCrawl.processor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

/**
 * 快代理免费代理IP爬取
 * @author 潭风
 * @time 2017-07-10
 */
public class KuaiDaiLiProcessor implements PageProcessor {

    // step1：抓取网站的相关配置设置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me()
                            .setCharset("utf-8")
                            //.setUserAgent("")
                            //.addCookie("key", "value")
                            //.setDomain("")
                            //.addHeader(Referer","https://github.com")
                            .setTimeOut(100000)
                            .setRetryTimes(3)
                            .setSleepTime(100);

    /**
     * 爬取逻辑处理
     * @param page page
     */
    @Override
    public void process(Page page) {
        // step2: 定义如何抽取页面信息，并保存
        System.out.println(page);
        // step3: 从页面发现后续的url地址来抓取
    }

    @Override
    public Site getSite() {
        return site;
    }

    // 125.31.19.27:80 澳门 高匿代理
    public static void beginCraw() {
        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(new Proxy("180.97.250.89", 80)));
        Spider.create(new KuaiDaiLiProcessor())
                .addUrl("http://www.66ip.cn/areaindex_35/1.html")
                .thread(5)
                //.setDownloader(httpClientDownloader)
                .run();
    }
}