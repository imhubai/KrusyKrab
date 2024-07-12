package top.hugongzi.dao;

import top.hugongzi.entity.User;

import java.util.List;

public interface UserDao {
    User getUser(String username) throws Exception;

    long getUserCount() throws Exception;

    List<User> getAllUser(int last_limit, int next_limit) throws Exception;

    boolean deleteUser(Long uid) throws Exception;

    User getUser(Long uid) throws Exception;

    User getUserByName(String username) throws Exception;

    boolean updateUser(Long uid, String userId, String password, String nickname, String email, String sex, String phone, String birthday, String usertype, String avatar);
}
