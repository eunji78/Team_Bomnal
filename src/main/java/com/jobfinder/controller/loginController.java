package com.jobfinder.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jobfinder.persistence.loginMapper;
import com.jobfinder.service.loginService;

@Controller
public class loginController {

    @Autowired
    loginMapper mapper;

    @Autowired
    loginService Service;

    @RequestMapping(value = "/loginform")
    public String loginform() {

        return "loginform";
    }

    @RequestMapping(value = "/signup_local")
    public String signup_local() {

        return "signup_local";
    }

    @RequestMapping(value = "/signup_company")
    public String signup_company() {

        return "signup_company";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "code", required = false) String code, HttpSession session, HttpServletResponse response) throws Exception{

        System.out.println("loginController!!");

        System.out.println("####code#####" + code);

        String access_Token = Service.getAccessToken(code);
        System.out.println("###access_Token#### : " + access_Token);

        Cookie token = new Cookie("authorize-access-token", access_Token);
        token.setPath("/");
        response.addCookie(token);

        //*
        HashMap<String, Object> userInfo = Service.getUserInfo(access_Token);
        System.out.println("###user_info### : " + userInfo);

        session.setAttribute("nickname", userInfo.get("nickname"));
        session.setAttribute("email", userInfo.get("email"));
        session.setAttribute("profile_image", userInfo.get("profile_image"));
        session.setAttribute("birthday", userInfo.get("birthday"));
        session.setAttribute("gender", userInfo.get("gender"));

        return "login";
    }

    @RequestMapping(value = "/v1/user/unlink")
    public String reset(HttpServletResponse response, HttpServletRequest request) throws Exception {

        System.out.println("Reset code");

        Cookie token = new Cookie("authorize-access-token", null);
        token.setPath("/");
        token.setMaxAge(0);
        response.addCookie(token);

        return "loginform";
    }
}
