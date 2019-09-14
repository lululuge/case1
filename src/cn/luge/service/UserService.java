package cn.luge.service;

import cn.luge.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User login(User user);
}
