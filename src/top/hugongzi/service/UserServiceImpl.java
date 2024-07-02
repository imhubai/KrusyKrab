package top.hugongzi.service;

import top.hugongzi.dao.UserDao;
import top.hugongzi.dao.UserDaoImpl;
import top.hugongzi.entity.User;

import java.util.Objects;

public class UserServiceImpl implements UserService{
    @Override
    public boolean validate(String username, String userpassword) throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUser(username);
        if (user == null) return false;
        else return Objects.equals(userpassword, user.getPassword());
    }
}
