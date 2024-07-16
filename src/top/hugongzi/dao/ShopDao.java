package top.hugongzi.dao;

import top.hugongzi.entity.Shop;

import java.util.List;

public interface ShopDao {
    Shop getShop(String shopId) throws Exception;
    long getShopCount() throws Exception;
    List<Shop> getAllShop(int last_limit, int next_limit) throws Exception;
    boolean deleteShop(int sid) throws Exception;
    Shop getShop(int sid) throws Exception;
    boolean updateShop(int sid, String shopId, String shopName, String shopAddress, String shopPhone,String shopType);
  }

