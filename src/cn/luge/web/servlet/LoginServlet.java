package cn.luge.web.servlet;

import cn.luge.domain.User;
import cn.luge.service.UserService;
import cn.luge.service.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码
        request.setCharacterEncoding("utf-8");
        // 2.获取用户登录数据
        String verifycode = request.getParameter("verifycode");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 3.验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER"); // 确保验证码一次性
        if (!checkcode_server.equalsIgnoreCase(verifycode)) {
            // 验证码错误
            // 提示信息
            request.setAttribute("login_msg", "验证码错误！");
            // 跳转login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else {
            Map<String, String[]> map = request.getParameterMap();
            // 4.封装user对象
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
//            try {
//                BeanUtils.populate(user, map);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
            // 5.调用service查询
            UserService service = new UserServiceImpl();
            User loginUser = service.login(user);
            // 6.判断是否登录成功？
            if (loginUser != null) {
                // 登录成功
                // 存储用户信息
                session.setAttribute("user", loginUser);
                // 重定向到index.jsp
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
            else {
                // 登录失败
                // 提示信息
                request.setAttribute("login_msg", "用户名或密码错误！");
                // 跳转login.jsp
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
