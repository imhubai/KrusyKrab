package top.hugongzi.service;

import top.hugongzi.entity.Cart;
import top.hugongzi.entity.User;
import top.hugongzi.entity.UserOrder;

import java.util.List;

public interface UserService {
    boolean validate(String username, String userpassword) throws Exception;

    List<User> getAllUser(int last_limit, int next_limit) throws Exception;

    boolean deleteUser(Long uid) throws Exception;

    long getUserCount() throws Exception;

    User getUserById(Long uid) throws Exception;

    User getUserByUserId(String username) throws Exception;

    boolean editUser(Long uid, String userId, String password, String nickname, String email, String sex, String phone, String birthday, String usertype, String avatar);

    List<UserOrder> getUserOrderByUserId(String userId) throws Exception;

    long addOrder(Cart cartResponse, String shopId, String userId, String isPaid,String json) throws Exception;

    UserOrder getOrder(int oid) throws Exception;

    boolean changeState(int oid,String state);
    boolean registerUser(String userId, String password, String nickname,  String phone, String sex, String birthday, String email );
}
