package com.xiangdangdang.controller;

import com.xiangdangdang.entity.User;
import com.xiangdangdang.service.UserService;
import com.xiangdangdang.service.impl.UserServiceImpl;
import com.xiangdangdang.util.LoginResult;
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

import java.util.List;
import java.util.Map;

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

    @RequestMapping("/islogin")
    @ResponseBody
    public Result isLogin() {
        Subject subject = SecurityUtils.getSubject();
        int flag = subject.isAuthenticated() ? 1 : 0;
        String errMsg = flag == 1 ? "已登录" : "未登录";
        return new Result(flag, errMsg);
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
        User user = userService.findByName(username);
        return new LoginResult(1, "登录成功", user.getUid(),user.getUsername(),user.getReputation());
    }

    @ResponseBody
    @RequestMapping("/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Result(1, "登出成功");
    }

    @ResponseBody
    @RequestMapping("/finduserbytaskid")
    public User findUserByTaskId(Long task_id) {
        User user = userService.findUserByTaskId(task_id);
        if (user == null) return new User();
        user.setPassword("就不告诉你");
        user.setSalt("就不告诉你");
        return user;
    }

    @ResponseBody
    @RequestMapping("/top10")
    public List<Map<String, String>> top10() {
        return userService.top10();
    }
}
