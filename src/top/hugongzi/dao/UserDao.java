package top.hugongzi.dao;

import top.hugongzi.entity.User;
import top.hugongzi.entity.UserOrder;

import java.time.LocalDateTime;
import java.util.List;

public interface UserDao {
    User getUser(String username) throws Exception;

    long getUserCount() throws Exception;

    List<User> getAllUser(int last_limit, int next_limit) throws Exception;

    boolean deleteUser(Long uid) throws Exception;

    User getUser(Long uid) throws Exception;

    User getUserByName(String username) throws Exception;

    boolean updateUser(Long uid, String userId, String password, String nickname, String email, String sex, String phone, String birthday, String usertype, String avatar);

    List<UserOrder> getUserOrderByUid(Long uid);

    long addOrder(long uid, long sid, long number, long tid, double price, String orderState, LocalDateTime orderTime, LocalDateTime orderOkTime, String payment, LocalDateTime orderCancelTime, String action, String json);

    long getLastNumber(long sid) throws Exception;

    UserOrder getOrder(long sid, long number) throws Exception;

    UserOrder getOrder(long oid) throws Exception;

    long addOrderDetail(long sid, long number, long pid, long quantity, double price, String tags, String comment) throws Exception;

    boolean registerUser(String userId, String password, String nickname, String phone, String sex, String birthday, String email);

    int getOrderCount(long sid) throws Exception;

    List<UserOrder> getAllOrder(long sid);

    boolean updateOrderState(int oid,String state);
}
