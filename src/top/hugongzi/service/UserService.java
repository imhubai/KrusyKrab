package top.hugongzi.service;

import top.hugongzi.entity.User;

import java.util.List;

public interface UserService {
    boolean validate(String username, String userpassword) throws Exception;

    List<User> getAllUser(int last_limit, int next_limit) throws Exception;

    boolean deleteUser(Long uid) throws Exception;

    long getUserCount() throws Exception;

    User getUserById(Long uid) throws Exception;

    boolean editUser(Long uid, String userId, String password, String nickname, String email, String sex, String phone, String birthday, String usertype, String avatar);
}
