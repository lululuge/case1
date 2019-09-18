package cn.luge.web.servlet;

import cn.luge.domain.User;
import cn.luge.service.UserService;
import cn.luge.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取用户id
        String id = request.getParameter("id");
        // 根据id查询到用户信息
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);
        //        // 存储user信息
        request.setAttribute("user", user);
        // 转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
