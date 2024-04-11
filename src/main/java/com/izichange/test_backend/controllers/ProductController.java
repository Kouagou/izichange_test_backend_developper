package com.izichange.test_backend.controllers;

import com.izichange.test_backend.exception.NotFoundException;
import com.izichange.test_backend.models.Product;
import com.izichange.test_backend.models.ProductDto;
import com.izichange.test_backend.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"", "/"})
    public String index(Model model){
        List<Product> products = this.repository.findAll();
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
            @Valid @ModelAttribute ProductDto productDto,
            BindingResult result
    ){
        if (result.hasErrors())
            return "product/new";

        Product product = new Product();
        product.setName(productDto.getName());
        product.setPriceHt(productDto.getPriceHt());
        this.repository.save(product);

        return "redirect:/product";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id){
        try {
            Optional<Product> optionalProduct = this.repository.findById(id);
            if (optionalProduct.isEmpty())
                throw new NotFoundException("Le Produit avec id : " + id + " non trouvé.");

            Product product = optionalProduct.get();
            model.addAttribute("product", product);

            ProductDto productDto = new ProductDto();
            productDto.setName(product.getName());
            productDto.setPriceHt(product.getPriceHt());

            model.addAttribute("productDto", productDto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "redirect:/product";
        }

        return "product/edit";
    }

    @PostMapping("/edit")
    public String edit(
            Model model, @RequestParam Long id,
            @Valid @ModelAttribute ProductDto productDto, BindingResult result
    ) {
        try {
            Optional<Product> optionalProduct = this.repository.findById(id);
            if (optionalProduct.isEmpty())
                throw new NotFoundException("Le Produit avec id : " + id + " non trouvé.");

            Product product = optionalProduct.get();
            model.addAttribute("product", product);

            if (result.hasErrors())
                return "product/edit";

            product.setName(productDto.getName());
            product.setPriceHt(productDto.getPriceHt());

            this.repository.save(product);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id){

        try {
            Optional<Product> optionalProduct = this.repository.findById(id);
            if (optionalProduct.isEmpty())
                throw new NotFoundException("Le Produit avec id : " + id + " non trouvé.");

            Product product = optionalProduct.get();

            this.repository.delete(product);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return "redirect:/product";
    }
}
