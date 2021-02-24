package com.szht.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@WebFilter(filterName = "CorsFilter", urlPatterns = "/*")
public class CorsFilter extends OncePerRequestFilter {
    private static List<String> whiteList = new ArrayList<>();//跨域白名单
    static {
        whiteList.add("http://localhost:10086");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //请求的地址
        String originUrl = request.getHeader("origin");
        //查看是否在白名单里面
        boolean isAllow = whiteList.contains(originUrl);

        if (isAllow) {
            response.setHeader("Access-Control-Allow-Origin", originUrl);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.setHeader("Access-Control-Max-Age", "1800");//30分钟
            response.setHeader("Access-Control-Allow-Headers", "x-requested-with, content-type");
            filterChain.doFilter(request, response);
        }else {
            System.out.println("没有访问权限!");
            return;
        }
    }
}
