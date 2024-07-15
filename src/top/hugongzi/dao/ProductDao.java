package top.hugongzi.dao;

import top.hugongzi.entity.Product;
import top.hugongzi.entity.ProductType;

import java.util.List;

public interface ProductDao {
    Product getProduct(String productId) throws Exception;

    long getProductCount() throws Exception;

    List<Product> getAllProduct(int last_limit, int next_limit) throws Exception;

    boolean deleteProduct(Long pid) throws Exception;

    Product getProduct(Long pid) throws Exception;

    Product getProductByProductId(String productId) throws Exception;

    ProductType getProductTypeByProductId(String productId) throws Exception;

    boolean updateProduct(Long pid, String productId, String productName, String productImg, double productPrice, long productType, String productDescription, String productTags) throws Exception;

    List<ProductType> getProductTypes();

    List<Product> getProductsByType(long productType);

}

