package cn.luge.dao;

import cn.luge.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);
}
