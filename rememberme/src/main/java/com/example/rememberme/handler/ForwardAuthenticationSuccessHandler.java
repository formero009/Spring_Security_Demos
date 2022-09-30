package com.example.rememberme.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: spring-security-demos
 * @description: 登录成功后处理Handler
 * @author: Mr.Wang
 * @create: 2022-09-30 14:16
 **/
public class ForwardAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public ForwardAuthenticationSuccessHandler(String url) {
        this.url = url;
    }

    /**
     * 对权限的处理
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //可以获取登录后的用户信息和权限信息
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities().stream().count());
        response.sendRedirect(this.url);
    }
}
