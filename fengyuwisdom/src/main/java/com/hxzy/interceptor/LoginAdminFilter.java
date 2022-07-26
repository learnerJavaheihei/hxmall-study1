package com.hxzy.interceptor;

import com.hxzy.config.SysConfig;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

/*
* 自定义登录拦截器
* */
public class LoginAdminFilter  implements HandlerInterceptor {

    /*设置ip白名单*/
    private HashSet<String> whiteUrl = new HashSet<>();

    public LoginAdminFilter(){
        whiteUrl.add("login.html");
        whiteUrl.add("login.do");
        whiteUrl.add("/api/captch/create.do");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1,获取当前的访问的地址
        String url = request.getRequestURI();
        for (String s : whiteUrl) {
            if (url.endsWith(s)){
                //如当前的url是白名单中的ip地址放行
                return true;
            }
        }

        //，检验是否登录
        if (request.getSession().getAttribute(SysConfig.CURRENTUSER)!=null){
            return true;
        }else{
            //未登录,拦截，发送到登录页
            response.sendRedirect("/login.html");
            return  false;
        }


    }
}
