package cn.luge.web.servlet;

import cn.luge.domain.PageBean;
import cn.luge.domain.User;
import cn.luge.service.UserService;
import cn.luge.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 分页查询
 */
@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取分页显示参数
        String currentPage_str = request.getParameter("currentPage"); // 当前页码
        String rows_str = request.getParameter("rows"); // 每页显示的条数

        // 默认参数设置
        if (currentPage_str == null || "".equals(currentPage_str)) {
            currentPage_str = "1";
        }
        if (rows_str == null || "".equals(rows_str)) {
            rows_str = "5";
        }
        // 控制向左翻页的按钮
        if (Integer.parseInt(currentPage_str) <= 1) {
            currentPage_str = "1";
        }
        // 获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        // 调用service查询PageBean
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage_str, rows_str, condition);
        // 存储PageBean
        request.setAttribute("pb", pb);
        // 存储条件查询参数，以便于后续的数据回写
        request.setAttribute("condition", condition);
        // 转发到list.jsp页面
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
