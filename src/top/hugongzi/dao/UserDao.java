package top.hugongzi.dao;

import top.hugongzi.entity.User;

public interface UserDao {
    User getUser(String username) throws Exception;
}
