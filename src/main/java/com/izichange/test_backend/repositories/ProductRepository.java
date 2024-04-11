package com.izichange.test_backend.repositories;

import com.izichange.test_backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
