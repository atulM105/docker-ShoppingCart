package com.mindtree.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.shoppingcart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	

	List<Product> findByProductName(String productName);

}
