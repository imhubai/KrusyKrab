package top.hugongzi.dao;

import top.hugongzi.entity.Shop;
import top.hugongzi.framework.db.JDBCTemplate;
import top.hugongzi.framework.db.RowMapper;

import java.util.List;

public class ShopDaoImpl implements ShopDao{
    private final RowMapper<Shop> rowMapper = (rs, rowNum) -> {
        Shop shop = new Shop();
        shop.setSid(rs.getLong("sid"));
        shop.setShopId(rs.getString("shop_id"));
        shop.setShopName(rs.getString("shop_name"));
        shop.setShopAddress(rs.getString("shop_address"));
        shop.setShopType(rs.getString("shop_type"));
        shop.setShopPhone(rs.getString("shop_phone"));
        shop.setCreatetime(rs.getTimestamp("createtime"));
        return shop;
    };
    public RowMapper<Shop> getRowMapper() {
        return rowMapper;
    }

    @Override
    public Shop getShop(String shopId) throws Exception {
        String sql = "select * from shop where shop_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, shopId);
    }

    @Override
    public long getShopCount() throws Exception {
        String sql = "select count(*) from shop";
        return JDBCTemplate.queryForObject(sql, (rs, rowNum) -> rs.getLong(1), null);
    }

    @Override
    public List<Shop> getAllShop(int last_limit, int next_limit) throws Exception {
        String sql = "select * from shop limit ?,?";
        return JDBCTemplate.query(sql, rowMapper, last_limit, next_limit);
    }

    @Override
    public boolean deleteShop(int sid) throws Exception {
        String sql = "delete from shop where sid = ?";
        return JDBCTemplate.update(sql, sid) >= 1;
    }

    @Override
    public Shop getShop(int sid) throws Exception {
        String sql = "select * from shop where sid = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, sid);
    }

    @Override
    public boolean updateShop(int sid, String shopId, String shopName, String shopAddress, String shopPhone, String shopType) {
        String sql = "update shop set shop_id= ? ,shop_name= ? ,shop_address= ? ,shop_type= ?, shop_phone= ? where sid= ?";
        return JDBCTemplate.update(sql, shopId, shopName, shopAddress, shopType, shopPhone, sid) >= 1;    }

}


