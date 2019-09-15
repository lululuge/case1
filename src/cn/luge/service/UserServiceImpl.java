package cn.luge.service;

import cn.luge.dao.UserDao;
import cn.luge.dao.impl.UserDaoImpl;
import cn.luge.domain.PageBean;
import cn.luge.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    // 调用dao完成查询
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void deleteSelectedUsers(String[] ids) {
        // 防止空指针异常
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage_str, String rows_str) {
        // 将两个字符串类型参数转为int类型
        int currentPage = Integer.parseInt(currentPage_str);
        int rows = Integer.parseInt(rows_str);
        // 创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        // 设置currentPage和rows属性
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        // 调用dao查询totalCount,并设置该属性
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);
        // 调用dao查询list<User>,并设置该属性
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows);
        pb.setList(list); // 参数分别是开始索引和每页的条数
        // 设置总的页码数
        int totalPage = (totalCount % rows) == 0 ? (totalCount / rows) : (totalCount / rows + 1);
        pb.setTotalPage(totalPage);
        return pb;
    }
}
