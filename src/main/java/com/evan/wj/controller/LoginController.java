package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import com.evan.wj.result.ResultFactory;
import com.evan.wj.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @Author: liuting
 * @Date: 2021/8/26 09:45
 * @Description:
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin//解决跨域问题
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session){

        String username = requestUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
        username = HtmlUtils.htmlEscape(username);// 对 html 标签进行转义，防止 XSS 攻击

        UsernamePasswordToken token = new UsernamePasswordToken(username, requestUser.getPassword());
        token.setRememberMe(true);
        try {
            subject.login(token);
            User user = userService.getByName(username);
            session.setAttribute("user",user);
            return ResultFactory.buildSuccessResult(user);
        }catch (AuthenticationException e){
            String msg = "账号密码错误";
            return ResultFactory.buildFailResult(msg);
        }
        /*User user = userService.get(username, requestUser.getPassword());
        //!Objects.equals("admin",username) || !Objects.equals("123",requestUser.getPassword())
        if (null == user){
//            String msg = "账号密码错误";
//            System.out.println("test");
            return new Result(400);
        }else {
            session.setAttribute("user",user);
            return new Result(200);
        }*/
    }

    @PostMapping("api/register")
    @ResponseBody
    public Result register(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

//        进行注册的非空判断
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            String message = "用户名和密码不能为空";
            return ResultFactory.buildFailResult(message);
        }


        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
        // 存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

    @GetMapping("api/logout")
    @ResponseBody
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        String msg = "成功登出";
        return ResultFactory.buildSuccessResult(msg);
    }

    @ResponseBody
    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }
}
