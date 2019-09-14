package cn.luge.service;

import cn.luge.dao.UserDao;
import cn.luge.dao.impl.UserDaoImpl;
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
}
