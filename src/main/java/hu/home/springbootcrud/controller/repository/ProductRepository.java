package hu.home.springbootcrud.controller.repository;

import hu.home.springbootcrud.controller.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}

