package top.hugongzi.service;

import top.hugongzi.entity.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getAllShop(int last_limit, int next_limit) throws Exception;
    boolean deleteShop(int sid) throws Exception;
    long getShopCount() throws Exception;
    Shop getShopById(int sid) throws Exception;
    Shop getShopByShopId(String shopId) throws Exception;
    boolean editShop(int sid, String shopId, String shopName, String shopAddress, String shopPhone,String shopType) throws Exception;
}

