package cn.luge.web.servlet;

import cn.luge.service.UserService;
import cn.luge.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectedServlet")
public class DeleteSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取选中的id数组
        String[] ids = request.getParameterValues("checkbox_id");
        // 调用service删除
        UserService service = new UserServiceImpl();
        service.deleteSelectedUsers(ids);
        // 跳转到UserListServlet
        response.sendRedirect(request.getContextPath() + "/findUserByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
