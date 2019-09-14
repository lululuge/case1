package cn.luge.service;

import cn.luge.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User login(User user);

    public void addUser(User user);

    public void deleteUser(String id);

    public User findUserById(String id);

    public void updateUser(User user);
}
