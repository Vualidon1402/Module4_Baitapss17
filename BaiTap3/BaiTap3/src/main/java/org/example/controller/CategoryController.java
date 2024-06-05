package org.example.controller;

import org.example.model.Category;
import org.example.model.Product;
import org.example.service.category.CategoryServiceImpl;
import org.example.service.category.ICategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class CategoryController {
    @GetMapping("/")
    public String hello(Model model) {
        ICategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/list-category";
    }

    @GetMapping("/add")
    public String addCategory() {
        return "category/add-category";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute Category category) {
        ICategoryService categoryService = new CategoryServiceImpl();
        categoryService.save(category);
        return "redirect:/";
    }



// ...

@GetMapping("/edit/{id}")
public String editCategory(@PathVariable("id") Integer id, Model model){
    ICategoryService categoryService = new CategoryServiceImpl();
    Category category = categoryService.findById(id);
    model.addAttribute("category", category);
    return "category/edit-category";
}

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute Category category) {
        ICategoryService categoryService = new CategoryServiceImpl();
        categoryService.save(category);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id){
        ICategoryService categoryService = new CategoryServiceImpl();
        categoryService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/list-product-of-category/{id}")
    public String listProductOfCategory(@PathVariable("id") Integer id, Model model){
        ICategoryService categoryService = new CategoryServiceImpl();
        List<Product> products = categoryService.findAllProductByCategory(id);
        model.addAttribute("products", products);
        return "category/list-product-of-category";
    }

}
