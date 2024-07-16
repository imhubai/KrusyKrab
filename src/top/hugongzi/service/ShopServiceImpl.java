package top.hugongzi.service;

import top.hugongzi.dao.ShopDao;
import top.hugongzi.dao.ShopDaoImpl;
import top.hugongzi.dao.UserDao;
import top.hugongzi.dao.UserDaoImpl;
import top.hugongzi.entity.Shop;
import top.hugongzi.entity.UserOrder;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    @Override
    public List<Shop> getAllShop(int last_limit, int next_limit) throws Exception {
        ShopDao shopDao = new ShopDaoImpl();
        return shopDao.getAllShop(last_limit, next_limit);
    }

    @Override
    public boolean deleteShop(int sid) throws Exception {
        ShopDao shopDao = new ShopDaoImpl();
        return shopDao.deleteShop(sid);
    }

    @Override
    public long getShopCount() throws Exception {
        ShopDao shopDao = new ShopDaoImpl();
        return shopDao.getShopCount();
    }


    @Override
    public Shop getShopById(int sid) throws Exception {
        ShopDao shopDao = new ShopDaoImpl();
        return shopDao.getShop(sid);
    }

    @Override
    public Shop getShopByShopId(String shopId) throws Exception {
        ShopDao shopDao = new ShopDaoImpl();
        return shopDao.getShop(shopId);
    }

    @Override
    public boolean editShop(int sid, String shopId, String shopName, String shopAddress, String shopPhone, String shopType) throws Exception {
        ShopDao shopDao = new ShopDaoImpl();
        return shopDao.updateShop(sid, shopId, shopName, shopAddress, shopPhone, shopType);
    }

    @Override
    public int getOrderCount(long sid) throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.getOrderCount(sid);
    }

    @Override
    public List<UserOrder> getUserOrderBySid(long sid) throws Exception {
        UserDao userDao = new UserDaoImpl();
        return userDao.getAllOrder(sid);
    }
}