package org.example.service.category;

import org.example.model.Category;
import org.example.model.Product;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    List<Product> findAllProductByCategory(Integer id);
    Category findById(Integer id);

    void save(Category category);

    void deleteById(Integer id);
}
