package com.aws.products.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aws.products.models.CategoryProduct;

public interface ProCateRepo extends CrudRepository<CategoryProduct, Long> {

}
