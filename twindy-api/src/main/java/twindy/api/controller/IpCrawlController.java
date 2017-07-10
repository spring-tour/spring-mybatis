package twindy.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import twindy.api.ipCrawl.processor.KuaiDaiLiProcessor;

/**
 * 爬取可用代理ip
 * @author 潭风
 * @time 2017-07-10
 */
@Controller
@RequestMapping("/proxy_ips")
public class IpCrawlController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void crawlProxyIps() {
        KuaiDaiLiProcessor.beginCraw();
    }
}
