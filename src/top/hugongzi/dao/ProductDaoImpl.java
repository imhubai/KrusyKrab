package top.hugongzi.dao;

import top.hugongzi.entity.Product;
import top.hugongzi.entity.ProductType;
import top.hugongzi.framework.db.JDBCTemplate;
import top.hugongzi.framework.db.RowMapper;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private final RowMapper<Product> rowMapper = (rs, rowNum) -> {
        Product product = new Product();
        product.setPid(rs.getLong("pid"));
        product.setProductId(rs.getString("product_id"));
        product.setProductName(rs.getString("product_name"));
        product.setProductImg(rs.getString("product_img"));
        product.setProductPrice(rs.getDouble("product_price"));
        product.setProductType(rs.getLong("product_type"));
        product.setProductDescription(rs.getString("product_description"));
        product.setProductTags(rs.getString("product_tags"));
        return product;
    };
    private final RowMapper<ProductType> rowMapper_productType = (rs, rowNum) -> {
        ProductType productType = new ProductType();
        productType.setTypeId(rs.getLong("type_id"));
        productType.setTypeName(rs.getString("type_name"));
        productType.setTypeImg(rs.getString("type_img"));
        return productType;
    };

    public RowMapper<Product> getRowMapper() {
        return rowMapper;
    }

    @Override
    public Product getProduct(String productId) throws Exception {
        String sql = "select * from product where product_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, productId);
    }

    @Override
    public long getProductCount() throws Exception {
        String sql = "select count(*) from product";
        return JDBCTemplate.queryForObject(sql, (rs, rowNum) -> rs.getLong(1), null);
    }

    @Override
    public List<Product> getAllProduct(int last_limit, int next_limit) throws Exception {
        String sql = "select * from product limit ?,?";
        return JDBCTemplate.query(sql, rowMapper, last_limit, next_limit);
    }

    @Override
    public boolean deleteProduct(Long pid) throws Exception {
        String sql = "delete from product where pid = ?";
        return JDBCTemplate.update(sql, pid) >= 1;
    }

    @Override
    public Product getProduct(Long pid) throws Exception {
        String sql = "select * from product where pid = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, pid);
    }

    @Override
    public Product getProductByProductId(String productId) throws Exception {
        String sql = "select * from product where product_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper, productId);
    }

    @Override
    public ProductType getProductTypeByProductId(String productId) throws Exception {
        long typeId = getProductByProductId(productId).getProductType();
        String sql = "select * from product_type where type_id = ?";
        return JDBCTemplate.queryForObject(sql, rowMapper_productType, typeId);
    }

    @Override
    public boolean updateProduct(Long pid, String productId, String productName, String productImg, double productPrice, long productType, String productDescription, String productTags) throws Exception {
        String sql = "update product set product_id = ?,product_name = ?,product_img = ?,product_price = ?,product_type = ?,product_description = ?,product_tags = ? where pid = ?";
        return JDBCTemplate.update(sql, productId, productName, productImg, productPrice, productType, productDescription, productTags, pid) >= 1;
    }

    @Override
    public List<ProductType> getProductTypes() {
       String sql = "select * from product_type";
       return JDBCTemplate.query(sql, rowMapper_productType, null);
    }

    @Override
    public List<Product> getProductsByType(long productType) {
        String sql = "select * from product where product_type = ?";
        return JDBCTemplate.query(sql, rowMapper, productType);
    }

}