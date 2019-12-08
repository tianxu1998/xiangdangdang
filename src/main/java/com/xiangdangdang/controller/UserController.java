package com.xiangdangdang.controller;

import com.xiangdangdang.entity.User;
import com.xiangdangdang.service.UserService;
import com.xiangdangdang.service.impl.UserServiceImpl;
import com.xiangdangdang.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/create")
    public Result create(String username, String passwd) {
        int code = 1;
        String errMsg = "成功";
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwd);
        try {
            userService.insertOne(user);
        } catch (Exception e) {
            e.printStackTrace();
            code = 0;
            errMsg = e.getMessage();
        }
        return new Result(code, errMsg);
    }

    @ResponseBody
    @RequestMapping("/login")
    public Result login(String username, String password, String remember, Model model) {
        System.out.println(username + " " + password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = null;
        if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
            token = new UsernamePasswordToken(username, password);
            if ("on".equals(remember)) {
                token.setRememberMe(true);
            } else {
                token.setRememberMe(false);
            }
        }
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            uae.printStackTrace();
            return new Result(-1,"未知账户");
        } catch (IncorrectCredentialsException ice) {
            ice.printStackTrace();
            return new Result(-2, "密码错误");
        } catch (ExcessiveAttemptsException e) {
            e.printStackTrace();
            return new Result(-3, "该账号登录失败次数过多");
        } catch (Exception e){
            e.printStackTrace();
            return new Result(-4, "未知错误");
        }
        return new Result(1, "登录成功");
    }
}
