package net.iot228.controller;

import net.iot228.entity.User;
import net.iot228.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Systemname:
 * @Author:彭俊龙
 * @Description:
 * @Date:Created 16:31 2021/6/4
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */
@Controller
public class LoginController {

    @Autowired
     LoginService loginService;

    /**
     * 描述：对登录按钮事件的响应，成功则跳转到主页，否则给出对应提示
     *
     * @param request 登录时的账号，密码
     * @return 返回对应的状态
     */
    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
            String user_name = request.getParameter("user_name");
            String user_pwd = request.getParameter("user_pwd");
            User user = loginService.findByName(user_name);
            try {
                if (user.getPassword().equals(user_pwd)) {
                    System.out.println("--------------登录成功------------");
                    System.out.println("账号：" + user_name + "密码：" + user_pwd);
                    map.put("result", "success");
                } else {
                    System.out.println("--------------密码错误------------");
                    map.put("result", "errpwd");
                }
            }catch (NullPointerException e) {
                    map.put("result", "yhbcz");
                    System.out.println("用户不存在");
                    System.out.println("账号："+user_name+"密码："+user_pwd);
            }
            return map;
    }



}
