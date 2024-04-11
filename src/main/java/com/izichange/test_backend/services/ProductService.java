package com.izichange.test_backend.services;

import com.izichange.test_backend.exception.NotFoundException;
import com.izichange.test_backend.models.Product;
import com.izichange.test_backend.models.ProductDto;
import com.izichange.test_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;
    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    public void saveProduct(Product product){
         this.repository.save(product);
    }

    public void updateProduct(ProductDto productDto, Long id){
        Optional<Product> optionalProduct = this.repository.findById(id);
        if (optionalProduct.isEmpty())
            throw new NotFoundException("Le Produit avec id : " + id + " non trouvé.");

        Product current = optionalProduct.get();
        current.setName(productDto.getName());
        current.setPriceHt(productDto.getPriceHt());
        this.repository.save(current);
    }

}
