package cn.luge.service;

import cn.luge.domain.PageBean;
import cn.luge.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User login(User user);

    void addUser(User user);

    void deleteUser(String id);

    User findUserById(String id);

    void updateUser(User user);

    void deleteSelectedUsers(String[] ids);

    PageBean<User> findUserByPage(String currentPage_str, String rows_str);
}
