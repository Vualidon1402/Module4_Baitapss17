package org.example.controller;

import org.example.model.Category;
import org.example.model.Product;
import org.example.service.category.CategoryServiceImpl;
import org.example.service.category.ICategoryService;
import org.example.service.product.IProductService;
import org.example.service.product.ProductImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @GetMapping("/product")
    public String product(Model model) {
        IProductService productService = new ProductImpl();
        List<Product> products = productService.findAllProduct();
        model.addAttribute("products", products);
        return "product/list-product";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model) {
        ICategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/add-product";
    }

    @PostMapping("/addProduct")
public String addProduct( @ModelAttribute Product product) {
        IProductService productService = new ProductImpl();
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){
        IProductService productService = new ProductImpl();
        Product product = productService.findByIdProduct(id);
        model.addAttribute("product", product);
        ICategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "product/edit-product";
    }

    @PostMapping("/editProduct")
    public String editProduct(@ModelAttribute Product product) {
        IProductService productService = new ProductImpl();
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        IProductService productService = new ProductImpl();
        productService.deleteByIdProduct(id);
        return "redirect:/product";
    }









}
