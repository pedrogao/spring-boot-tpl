package com.pedro.tpl.v1.controller;


import com.pedro.tpl.common.token.JWT;
import com.pedro.tpl.v1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author pedro
 * @since 2019-08-04
 */
@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private JWT jwt;

    @GetMapping("/")
    public User index() {
        User user = new User();
        user.setNickname("pedro");
        user.setPasswordEncrypt("123456");
        return user;
    }

    @PostMapping("/login")
    public Map login() {
        Map<String, String> res = new HashMap();
        String accessToken = jwt.generateAccessToken(1L);
        res.put("access_token", accessToken);
        return res;
    }
}
