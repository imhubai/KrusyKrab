package top.hugongzi.service;

import top.hugongzi.dao.ProductDao;
import top.hugongzi.dao.ProductDaoImpl;
import top.hugongzi.entity.Product;
import top.hugongzi.entity.ProductType;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAllProduct(int last_limit, int next_limit) throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.getAllProduct(last_limit, next_limit);
    }

    @Override
    public boolean deleteProduct(Long pid) throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.deleteProduct(pid);
    }

    @Override
    public long getProductCount() throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.getProductCount();
    }

    @Override
    public Product getProductById(Long pid) throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.getProduct(pid);
    }

    @Override
    public Product getProductByProductId(String productId) throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.getProductByProductId(productId);
    }

    @Override
    public ProductType getProductTypeByProductId(String productId) throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.getProductTypeByProductId(productId);
    }

    @Override
    public boolean editProduct(Long pid, String productId, String productName, String productImg, double productPrice, long productType, String productDescription, String productTags) throws Exception {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.updateProduct(pid, productId, productName, productImg, productPrice, productType, productDescription, productTags);
    }

    @Override
    public List<Product> getProductsByType(long productType) {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.getProductsByType(productType);
    }

    @Override
    public List<ProductType> getProductTypes() {
        ProductDao productDao = new ProductDaoImpl();
        return productDao.getProductTypes();
    }
}