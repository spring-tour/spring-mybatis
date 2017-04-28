package twindy.admin.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import twindy.common.utils.encrypt.Base64Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 描述：
 *
 * @author twindy
 * @time 2017-04-19
 */
@Controller
public class HomeController {

    private static final Log log = LogFactory.getLog(HomeController.class);

    @ResponseBody
    @RequestMapping(value = {"/aa"})
    public JSONObject doAction() {
        JSONObject json = new JSONObject();
        log.info(Base64Utils.encode("aaaa"));
        json.put("1", "中国");
        json.put("2", "美国");
        json.put("3", "朝鲜");
        return json;
    }

    @RequestMapping(value = {"/home"})
    public String homePage(HttpServletRequest request, HttpServletResponse response){
        return "home";
    }
}
