package org.example.service.product;

import org.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();

    Product findByIdProduct(Integer id);

    void saveProduct(Product product);

    void deleteByIdProduct(Integer id);
}
