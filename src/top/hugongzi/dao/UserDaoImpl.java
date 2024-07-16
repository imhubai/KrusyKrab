package top.hugongzi.dao;

import top.hugongzi.entity.OrderDetails;
import top.hugongzi.entity.User;
import top.hugongzi.entity.UserOrder;
import top.hugongzi.framework.db.JDBCTemplate;
import top.hugongzi.framework.db.RowMapper;

import java.time.LocalDateTime;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final RowMapper<User> rowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUid(rs.getLong("uid"));
        user.setUserId(rs.getString("user_id"));
        user.setPassword(rs.getString("password"));
        user.setNickname(rs.getString("nickname"));
        user.setEmail(rs.getString("email"));
        user.setSex(rs.getString("sex"));
        user.setPhone(rs.getString("phone"));
        user.setBirthday(rs.getDate("birthday"));
        user.setUsertype(rs.getLong("usertype"));
        user.setCreatetime(rs.getTimestamp("createtime"));
        user.setAvatar(rs.getString("avatar"));
        return user;
    };

    private final RowMapper<UserOrder> rowMapper_userOrder = (rs, rowNum) -> {
        UserOrder userOrder = new UserOrder();
        userOrder.setOid(rs.getLong("oid"));
        userOrder.setUid(rs.getLong("uid"));
        userOrder.setSid(rs.getLong("sid"));
        userOrder.setNumber(rs.getLong("number"));
        userOrder.setTid(rs.getLong("tid"));
        userOrder.setOrderPrice(rs.getDouble("order_price"));
        userOrder.setOrderState(rs.getString("order_state"));
        userOrder.setOrderTime(rs.getTimestamp("order_time"));
        userOrder.setOrderOkTime(rs.getTimestamp("order_ok_time"));
        userOrder.setPayment(rs.getString("payment"));
        userOrder.setOrderCancelTime(rs.getTimestamp("order_cancel_time"));
        userOrder.setAction(rs.getString("action"));
        userOrder.setCartJson(rs.getString("cartJson"));
        return userOrder;
    };

    private final RowMapper<OrderDetails> rowMapper_orderDetails = (rs, rowNum) -> {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setDid(rs.getLong("did"));
        orderDetails.setOid(rs.getLong("oid"));
        orderDetails.setPid(rs.getLong("pid"));
        orderDetails.setQuantity(rs.getLong("quantity"));
        orderDetails.setPrice(rs.getDouble("price"));
        orderDetails.setTags(rs.getString("tags"));
        orderDetails.setComment(rs.getString("comment"));
        return orderDetails;
    };

    public RowMapper<User> getRowMapper() {
        return rowMapper;
    }

    public RowMapper<UserOrder> getUserOrderRowMapper() {
        return rowMapper_userOrder;
    }


    @Override
    public User getUser(String username) throws Exception {
        String sql = "select * from user where user_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, username);
    }

    @Override
    public long getUserCount() throws Exception {
        String sql = "select count(*) from user";
        return JDBCTemplate.queryForObject(sql, (rs, rowNum) -> rs.getLong(1), null);
    }

    @Override
    public List<User> getAllUser(int last_limit, int next_limit) throws Exception {
        String sql = "select * from user limit ?,?";
        return JDBCTemplate.query(sql, rowMapper, last_limit, next_limit);
    }

    @Override
    public boolean deleteUser(Long uid) throws Exception {
        String sql = "delete from user where uid = ?";
        return JDBCTemplate.update(sql, uid) >= 1;
    }

    @Override
    public User getUser(Long uid) throws Exception {
        String sql = "select * from user where uid = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, uid);
    }

    @Override
    public User getUserByName(String username) throws Exception {
        String sql = "select * from user where user_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, username);
    }

    @Override
    public boolean updateUser(Long uid, String userId, String password, String nickname, String email, String sex, String phone, String birthday, String usertype, String avatar) {
        String sql = "update user set user_id = ?,password = ?,nickname = ?,email = ?,sex = ?,phone = ?,birthday = ?,usertype = ?,avatar = ? where uid = ?";
        return JDBCTemplate.update(sql, userId, password, nickname, email, sex, phone, birthday, usertype, avatar, uid) >= 1;
    }

    @Override
    public List<UserOrder> getUserOrderByUid(Long uid) {
        String sql = "select * from user_order where uid = ?";
        return JDBCTemplate.query(sql, rowMapper_userOrder, uid);
    }

    @Override
    public long addOrder(long uid, long sid, long number, long tid, double price, String orderState, LocalDateTime orderTime, LocalDateTime orderOkTime, String payment, LocalDateTime orderCancelTime, String action, String json) {
        String sql = "insert into user_order (uid,sid,number,tid,order_price,order_state,order_time,order_ok_time,payment,order_cancel_time,action,cartJson) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        return JDBCTemplate.update(sql, uid, sid, number, tid, price, orderState, orderTime, orderOkTime, payment, orderCancelTime, action, json);
    }

    @Override
    public long getLastNumber(long sid) throws Exception {
        String sql = "SELECT * FROM user_order WHERE sid = ? ORDER BY oid DESC LIMIT 1;";
        UserOrder userOrder = JDBCTemplate.queryForObject(sql, rowMapper_userOrder, sid);
        return userOrder.getNumber();
    }

    @Override
    public UserOrder getOrder(long sid, long number) throws Exception {
        String sql = "select * from user_order where sid=? and number=?";
        return JDBCTemplate.queryForObject(sql, rowMapper_userOrder, sid, number);
    }

    @Override
    public UserOrder getOrder(long oid) throws Exception {
        String sql = "select * from user_order where oid=?";
        return JDBCTemplate.queryForObject(sql, rowMapper_userOrder, oid);

    }

    @Override
    public long addOrderDetail(long sid, long number, long pid, long quantity, double price, String tags, String comment) throws Exception {
        UserOrder userOrder = getOrder(sid, number);
        if (userOrder != null) {
            String sql = "insert into order_details (oid,pid,quantity,price,tags,comment) values (?,?,?,?,?,?)";
            return JDBCTemplate.update(sql, userOrder.getOid(), pid, quantity, price, tags, comment);
        } else return -1;
    }

    @Override
    public boolean registerUser(String userId, String password, String nickname, String phone, String sex, String birthday, String email) {
        String sql = "insert into user (user_id,password,nickname,email,sex,phone,birthday) values (?,?,?,?,?,?,?)";
        return JDBCTemplate.update(sql, userId, password, nickname, email, sex, phone, birthday) >= 1;
    }

    @Override
    public int getOrderCount(long sid) throws Exception {
        String sql = "select count(*) from user_order where sid =" + sid;
        return JDBCTemplate.queryForObject(sql, (rs, rowNum) -> rs.getInt(1), null);
    }

    @Override
    public List<UserOrder> getAllOrder(long sid) {
        String sql = "select * from user_order where sid=?";
        return JDBCTemplate.query(sql, rowMapper_userOrder, sid);
    }

    @Override
    public boolean updateOrderState(int oid, String state) {
        String sql = "update user_order set order_state = ? where oid = ?";
        return JDBCTemplate.update(sql, state, oid) >= 1;
    }
}
