package twindy.api.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import twindy.common.http.HttpClientUtils;

import java.io.IOException;

/**
 * 小说相关控制器
 * @author 潭风
 * @time 2017-07-08
 */
@Controller
@RequestMapping("/novels")
public class NovelsController {
    private static final Log log = LogFactory.getLog(NovelsController.class);
    private static final String NOVELS_URL = "https://api.zhuishushenqi.com";

    /**
     * 查询书籍
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public JSONObject queryNovels(@RequestParam(value = "keyword") String keyword,
                                  @RequestParam(value = "start_num", required = false) String startNum,
                                  @RequestParam(value = "end_num", required = false) String endNum) {
        JSONObject json = new JSONObject();
        if(StringUtils.isAnyBlank(keyword)) {
            json.put("code", -1);
            json.put("message", "客户端参数不为空");
            return json;
        }
        if(StringUtils.isAnyBlank(startNum, endNum)) {
            startNum = "0";
            endNum = "50";
        }
        String url = NOVELS_URL + "/book/fuzzy-search?query=" + keyword + "&start=" + startNum + "&limit=" + endNum;
        try {
            String result = HttpClientUtils.get(url);
            return JSONObject.parseObject(result);
        } catch (IOException e) {
            log.error("查询书籍失败：" + e);
        }
        return null;
    }

    /**
     * 书籍热门榜
     * @return
     */
    public JSONObject queryHotNovels() {
        return null;
    }

    /**
     * 查询书籍信息
     * @return
     */
    public JSONObject queryNovelInfoById() {
        return null;
    }
    /**
     * 查询书籍对应的其他来源
     * @return
     */
    public JSONObject queryOtherSourceById() {
        return null;
    }

    /**
     * 查看书籍章节对应内容
     * @return
     */
    public JSONObject queryNovelContent() {
        return null;
    }

    /**
     * 搜索作者的相关作品
     * @return
     */
    public JSONObject queryNovelsByAuthor() {
        return null;
    }
}
