package org.example.service.category;

import org.example.dao.category.CategoryDaoImpl;
import org.example.dao.category.ICategporyDao;
import org.example.model.Category;
import org.example.model.Product;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    private static final ICategporyDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
    @Override
    public List<Product> findAllProductByCategory(Integer id) {
        return categoryDao.findAllProductByCategory(id);
    }
    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryDao.deleteById(id);
    }

}
