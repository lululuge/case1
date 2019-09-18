package cn.luge.dao.impl;

import cn.luge.dao.UserDao;
import cn.luge.domain.User;
import cn.luge.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    // 使用JDBC操作数据库
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询不到时返回null
        return null;
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values (null, ?, ?, ?, ?, ?, ?, null, null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql, id);
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?";
        template.update(sql, user.getName(), user.getGender(),
                user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        // 定义一个基础查询语句，以便于后续的拼接
        String sql = "select count(*) from user where 1 = 1";
        // 用于sql语句拼接
        StringBuilder sb = new StringBuilder(sql);
        // 遍历condition
        Set<String> keys = condition.keySet();
        // 定义一个list存储value,作为参数列表给？赋值
        List<Object> params = new ArrayList<Object>();
        for (String key : keys) {
            if (key.equals("currentPage") || key.equals("rows")) {
                continue;
            }
            // 已知condition中的值都是单个的
            String value = condition.get(key)[0];
            // 判断value是否有值
            if (value != null && ! "".equals(value)) {
                // 有值,则拼接sql语句
                sb.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }
//        System.out.println(sb.toString());
//        System.out.println(params);
//        System.out.println(template.queryForObject(sb.toString(), Integer.class, params.toArray()));
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
//        String sql = "select * from user limit ?, ?";
        // 定义一个基础查询语句，以便于后续的拼接
        String sql = "select * from user where 1 = 1";
        // 用于sql语句拼接
        StringBuilder sb = new StringBuilder(sql);
        // 遍历condition
        Set<String> keys = condition.keySet();
        // 定义一个list存储value,作为参数列表给？赋值
        List<Object> params = new ArrayList<Object>();
        for (String key : keys) {
            if (key.equals("currentPage") || key.equals("rows")) {
                continue;
            }
            // 已知condition中的值都是单个的
            String value = condition.get(key)[0];
            // 判断value是否有值
            if (value != null && ! "".equals(value)) {
                // 有值,则拼接sql语句
                sb.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }
        sb.append(" limit ?, ? ");
        params.add(start);
        params.add(rows);
        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), params.toArray());
    }


}
