package org.example.service.product;

import org.example.dao.product.IProductDao;
import org.example.dao.product.ProductDaoImpl;
import org.example.model.Product;

import java.util.List;

public class ProductImpl implements IProductService{
    private static final IProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> findAllProduct() {
        return productDao.findAllProduct();
    }

    @Override
    public Product findByIdProduct(Integer id) {
        return productDao.findByIdProduct(id);
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    @Override
    public void deleteByIdProduct(Integer id) {
        productDao.deleteByIdProduct(id);
    }
}
