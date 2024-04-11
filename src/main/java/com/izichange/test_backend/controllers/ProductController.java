package com.izichange.test_backend.controllers;

import com.izichange.test_backend.models.Product;
import com.izichange.test_backend.models.ProductDto;
import com.izichange.test_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Product> products = this.service.getAllProducts();
        model.addAttribute("products", products);
        return "product/index";
    }

    /* On a dû nommer cette méthode create vu que new est un nom réservé du langage Java*/
    @GetMapping("/new")
    public String showCreatePage(Model model){
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "product/new";
    }

    @PostMapping("/new")
    public String create(
            @ModelAttribute ProductDto productDto,
            BindingResult result
    ){

        return "redirect:/product";
    }
}
