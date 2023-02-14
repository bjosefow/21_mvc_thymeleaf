package com.example.bjosefow_21_mvc_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("categories", Category.values());
        return "home";
    }

    @GetMapping("/lista")
    String showProductListWithCategory(@RequestParam(required = false) String category, Model model) {
        List<Product> productList;
        if (category != null) {
            productList = productRepository.getProductListWithCategory(category);
        } else {
            productList = productRepository.getProductList();
        }
        double sumPriceForProducts = productRepository.getSumPriceForProducts(productList);
        model.addAttribute("productList", productList);
        model.addAttribute("sumPrice", sumPriceForProducts);
        Category productCategory = Category.getCategoryFromDesc(category);
        model.addAttribute("category", productCategory);
        return "product-list";
    }

    @GetMapping("/add")
    String addProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", Category.values());
        return "add-product";
    }

    @PostMapping("/save")
    String save(Product product) {
        productRepository.addProduct(product);
        return "redirect:/";
    }
}
