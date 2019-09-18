package cn.luge.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 1.强制类型转换
        HttpServletRequest request = (HttpServletRequest) req;
        // 2.获取uri
        String uri = request.getRequestURI();
        // 3.判断是否为与登录相关的资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") ||
                uri.contains("/checkCodeServlet") || uri.contains("/css/") ||
                uri.contains("/fonts/") || uri.contains("/js/")) {
            // 是，放行
            chain.doFilter(req, resp);
        }
        else {
            // 否，判断是否登录
            HttpSession session = request.getSession();
            if (session.getAttribute("user") != null) {
                // 已登录,放行
                chain.doFilter(req, resp);
            }
            else {
                // 未登录，跳转到登录页面
                request.setAttribute("login_msg", "请登录后查看相关信息！");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
