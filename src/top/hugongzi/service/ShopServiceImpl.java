package top.hugongzi.service;

import top.hugongzi.dao.ShopDao;
import top.hugongzi.dao.ShopDaoImpl;
import top.hugongzi.entity.Shop;

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
    public boolean editShop(int sid, String shopId, String shopName, String shopAddress, String shopPhone, String shopType) throws Exception {
        ShopDao shopDao = new ShopDaoImpl();
        return shopDao.updateShop(sid, shopId, shopName, shopAddress, shopPhone, shopType);
    }
}