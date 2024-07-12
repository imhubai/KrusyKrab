package top.hugongzi.service;

import top.hugongzi.dao.UserDao;
import top.hugongzi.dao.UserDaoImpl;
import top.hugongzi.entity.User;

import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {
    @Override
    public boolean validate(String username, String userpassword) throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUser(username);
        if (user == null) return false;
        else return Objects.equals(userpassword, user.getPassword());
    }

    @Override
    public List<User> getAllUser(int last_limit, int next_limit) throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.getAllUser(last_limit, next_limit);
    }

    @Override
    public boolean deleteUser(Long uid) throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.deleteUser(uid);
    }

    @Override
    public long getUserCount() throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.getUserCount();
    }

    @Override
    public User getUserById(Long uid) throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.getUser(uid);
    }

    @Override
    public User getUserByName(String username) throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.getUserByName(username);
    }

    @Override
    public boolean editUser(Long uid, String userId, String password, String nickname, String email, String sex, String phone, String birthday, String usertype, String avatar) {
        UserDao userDao = new UserDaoImpl();
        return userDao.updateUser(uid, userId, password, nickname, email, sex, phone, birthday, usertype, avatar);
    }
}
