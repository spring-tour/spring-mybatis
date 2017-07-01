package twindy.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import twindy.admin.user.entity.User;
import twindy.admin.user.service.UserService;

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

    @Autowired
    private UserService userService;
    private static final Log log = LogFactory.getLog(HomeController.class);


    @ResponseBody
    @RequestMapping(value = {"/user"})
    public JSONObject doAction() {
        User user = new User();
        user.setId("1");
        JSONObject json = (JSONObject) JSON.toJSON(userService.queryUser(user));
        log.info(json);
        return json;
    }

    @RequestMapping(value = {"/home"})
    public String homePage(HttpServletRequest request, HttpServletResponse response){
        return "home";
    }
}
