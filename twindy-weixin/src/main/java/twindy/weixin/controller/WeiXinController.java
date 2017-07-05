package twindy.weixin.controller;

import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    /**
     *
     * @param signature 签名
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr
     * @return
     */
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

    /**
     * 获取jsapi_ticket相关信息
     * @param currentUrl 当前网页的url 不包含#后面的参数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/js_api_configs", method = RequestMethod.GET)
    public JSONObject getJsApiticket(@RequestParam(name = "currentUrl", required = true) String currentUrl) {
        JSONObject result = new JSONObject();
        try {
            WxJsapiSignature wxJsapiSignature = weiXinService.createJsapiSignature(currentUrl);
            result.put("appId", wxJsapiSignature.getAppId());
            result.put("timestamp", wxJsapiSignature.getTimestamp());
            result.put("nonceStr", wxJsapiSignature.getNonceStr());
            result.put("signature", wxJsapiSignature.getSignature());
            log.info("access_token:" + weiXinService.getAccessToken());
            return result;
        } catch (WxErrorException e) {
            log.error("创建jsapi_ticket签名失败:" + e);
        }
        return null;
    }
    /**
     * 构造网页授权url，然后构成超链接让用户点击
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    public String getOAuth2Url() {
        try {
            // state 重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
            String state = "helloworld";
            return weiXinService.oauth2buildAuthorizationUrl("http://twindyorg.tunnel.echomod.cn/twindy/weixin/portal/redirect", WxConsts.OAUTH2_SCOPE_USER_INFO, state);
        } catch (Exception e) {
            log.error("创建jsapi_ticket签名失败:" + e);
        }
        return null;
    }
    /**
     * 构造网页授权url，然后构成超链接让用户点击
     * @return
     */
    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state", required = false) String state, Model model){
        try {
            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = weiXinService.oauth2getAccessToken(code);
            WxMpUser wxMpUser = weiXinService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
            log.info(wxMpUser);
            model.addAttribute("openId", wxMpUser.getOpenId());
            model.addAttribute("nickname", wxMpUser.getNickname());
            model.addAttribute("sex", wxMpUser.getSex());
            model.addAttribute("province", wxMpUser.getProvince());
            model.addAttribute("headImgUrl", wxMpUser.getHeadImgUrl());
            return "redirect:http:www.baidu.com";
        } catch (WxErrorException e) {
           log.error(e);
        }
        return null;
    }
}
