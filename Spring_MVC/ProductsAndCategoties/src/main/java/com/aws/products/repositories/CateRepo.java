package com.aws.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aws.products.models.Category;
import com.aws.products.models.Product;

@Repository
public interface CateRepo extends CrudRepository<Category, Long> {
	
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product p);

}
