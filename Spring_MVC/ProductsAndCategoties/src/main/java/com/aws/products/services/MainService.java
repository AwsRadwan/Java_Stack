package com.aws.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.aws.products.models.Category;
import com.aws.products.models.Product;
import com.aws.products.repositories.CateRepo;
import com.aws.products.repositories.ProCateRepo;
import com.aws.products.repositories.ProRepo;

@Service
public class MainService {
	private final CateRepo cateRepo;
	private final ProRepo proRepo;
	private final ProCateRepo pcr;
	
	public MainService(CateRepo cateRepo, ProRepo proRepo, ProCateRepo pcr) {
		this.cateRepo = cateRepo;
		this.proRepo = proRepo;
		this.pcr = pcr;
	}
	
	public List<Product> findAllPro(){
		return proRepo.findAll();
	}
	public List<Category> findAllCate(){
		return cateRepo.findAll();
	}
	
	public void creatProduct(Product pro) {
		proRepo.save(pro);
	}
	public void creatCategory(Category cate) {
		cateRepo.save(cate);
	}
	public void saveCate(Category c) {
		cateRepo.save(c);
	}
	public void savePro(Product p) {
		proRepo.save(p);
	}
	
	public void deletePro(Product pro) {
    	proRepo.delete(pro);
    }
    public void deleteCate(Category n) {
    	cateRepo.delete(n);
    }
    
    public Product findPro(Long id) {
        Optional<Product> optionalx = proRepo.findById(id);
        if(optionalx.isPresent()) {
            return optionalx.get();
        } else {
            return null;
        }
    }
    public Category findCate(Long id) {
        Optional<Category> optionalCate = cateRepo.findById(id);
        if(optionalCate.isPresent()) {
            return optionalCate.get();
        } else {
            return null;
        }
    }
    
    public List<Product> otherPro(Long id){
    	Optional<Category> optionalCate = cateRepo.findById(id);
        if(optionalCate.isPresent()) {
        	Category c = optionalCate.get();
            return proRepo.findByCategoriesNotContains(c);
        } else {
            return null;
        }
    }
    public List<Category> otherCate(Long id){
    	Optional<Product> optionalPro = proRepo.findById(id);
        if(optionalPro.isPresent()) {
        	Product p = optionalPro.get();
            return cateRepo.findByProductsNotContains(p);
        } else {
            return null;
        }
    }

}
