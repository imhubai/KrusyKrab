package top.hugongzi.service;

import top.hugongzi.dao.*;
import top.hugongzi.entity.Cart;
import top.hugongzi.entity.Shop;
import top.hugongzi.entity.User;
import top.hugongzi.entity.UserOrder;

import java.time.LocalDateTime;
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
    public User getUserByUserId(String username) throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.getUserByName(username);
    }

    @Override
    public boolean editUser(Long uid, String userId, String password, String nickname, String email, String sex, String phone, String birthday, String usertype, String avatar) {
        UserDao userDao = new UserDaoImpl();
        return userDao.updateUser(uid, userId, password, nickname, email, sex, phone, birthday, usertype, avatar);
    }

    @Override
    public List<UserOrder> getUserOrderByUserId(String userId) throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserByName(userId);
        if (user == null) return null;
        return userDao.getUserOrderByUid(user.getUid());
    }

    @Override
    public long addOrder(Cart cartResponse, String shopId, String userId, String isPaid,String json) throws Exception {
        boolean paid = "true".equals(isPaid);
        UserDao userDao = new UserDaoImpl();
        ShopDao shopDao = new ShopDaoImpl();
        ProductDao productDao = new ProductDaoImpl();
        User user = userDao.getUser(userId);
        Shop shop = shopDao.getShop(shopId);
        long number = userDao.getLastNumber(shop.getSid()) == 0 ? 1 : userDao.getLastNumber(shop.getSid()) + 1;
        String state = paid ? "待出餐" : "未支付";
        //TODO Tickets
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fiveMinutesLater = now.plusMinutes(5);
        long r = userDao.addOrder(
                user.getUid(),
                shop.getSid(),
                number,
                0,
                Double.parseDouble(cartResponse.getPrice()),
                state,
                now,
                null,
                "现金",
                fiveMinutesLater,
                cartResponse.getAction(),
                json
        );
        if(r>0){
            cartResponse.getItems().forEach((k,v)->{
                try {
                    userDao.addOrderDetail(shop.getSid(),number,productDao.getProduct(v.getProductId()).getPid(),v.getProductCount(),v.getProductPrice(),v.getProductTags(),v.getProductDescription());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
        return userDao.getOrder(shop.getSid(), number).getOid();
    }

    @Override
    public UserOrder getOrder(int oid) throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.getOrder(oid);
    }

    @Override
    public boolean changeState(int oid, String state) {
       UserDao userDao = new UserDaoImpl();
       return userDao.updateOrderState( oid, state);
    }

    @Override
    public boolean registerUser(String userId, String password, String nickname, String phone, String sex, String birthday, String email) {
        UserDao userDao = new UserDaoImpl();
        return userDao.registerUser(userId, password, nickname, phone, sex, birthday, email);
    }
}
