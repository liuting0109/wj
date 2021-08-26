package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import com.evan.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

/**
 * @Auther: liuting
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
    public Result login(@RequestBody User requestUser){
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        //!Objects.equals("admin",username) || !Objects.equals("123",requestUser.getPassword())
        if (null == user){
//            String msg = "账号密码错误";
//            System.out.println("test");
            return new Result(400);
        }else {
            return new Result(200);
        }
    }
}
