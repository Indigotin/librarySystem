package com.Filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LoginFilter implements Filter {

    public static List<String> pattenURL = new ArrayList<String>();

    public void init(FilterConfig filterConfig) throws ServletException {

        pattenURL.add("login");// 登录jsp
        pattenURL.add("checkAccount");// 登录方法
        //pattenURL.add("css");// css
        //pattenURL.add("image");// image
        //pattenURL.add("js");// js
        //pattenURL.add("fonts");// fonts
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession();
        // 登陆url
        String loginUrl = httpRequest.getContextPath() + "/login";
        String url = httpRequest.getRequestURI().toString();

        // 注：在pattenURL中的全部不拦截 url.indexOf(urlStr) > -1 表示urlStr在url中出现过，出现就不拦截
        for (String urlStr : pattenURL) {
            if (url.indexOf(urlStr) > -1) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        //超时处理，ajax请求超时设置超时状态，页面请求超时则返回提示并重定向，session.getAttribute("")是获取到登录人的session信息
        if (session.getAttribute("") == null) {
            // 判断是否为ajax请求
            if (httpRequest.getHeader("x-requested-with") != null
                    && httpRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                httpResponse.addHeader("sessionstatus", "timeOut"); // 返回超时标识
                httpResponse.addHeader("loginPath", loginUrl);// 返回url
                filterChain.doFilter(servletRequest, servletResponse);// 不可少，否则请求会出错

            } else {
                // alert('会话过期,请重新登录');
                String str = "<script language='javascript'>" + "window.top.location.href='" + loginUrl + "';</script>";
                servletResponse.setContentType("text/html;charset=UTF-8");// 解决中文乱码
                try {
                    PrintWriter writer = servletResponse.getWriter();
                    writer.write(str);
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else {

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
