package twindy.weixin.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import twindy.weixin.service.WeiXinService;

import javax.annotation.Resource;

/**
 * 微信控制器
 * @author senola
 * @time 2017-07-04
 */
@Controller
@RequestMapping("/portal")
public class WeiXinController {

    @Resource
    private WeiXinService weiXinService;
    private final static Log log = LogFactory.getLog(WeiXinController.class);

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String auth(@RequestParam(name = "signature", required = false) String signature,
                           @RequestParam(name = "timestamp", required = false) String timestamp,
                           @RequestParam(name = "nonce", required = false) String nonce,
                           @RequestParam(name = "echostr", required = false) String echostr) {

        if(StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        if (weiXinService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }
        return null;
    }
}
