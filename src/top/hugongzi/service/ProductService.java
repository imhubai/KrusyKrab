package top.hugongzi.service;

import top.hugongzi.entity.Product;
import top.hugongzi.entity.ProductType;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct(int last_limit, int next_limit) throws Exception;

    boolean deleteProduct(Long pid) throws Exception;

    long getProductCount() throws Exception;

    Product getProductById(Long pid) throws Exception;

    Product getProductByProductId(String productId) throws Exception;

    ProductType getProductTypeByProductId(String productId) throws Exception;

    boolean editProduct(Long pid, String productId, String productName, String productImg, double productPrice, long productType, String productDescription, String productTags) throws Exception;

    List<Product> getProductsByType(long productType);

    List<ProductType> getProductTypes();
}

