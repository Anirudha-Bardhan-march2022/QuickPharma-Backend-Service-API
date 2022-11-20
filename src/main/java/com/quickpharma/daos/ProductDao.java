package com.quickpharma.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickpharma.entities.Product;
import com.quickpharma.entities.ProductType;

public interface ProductDao extends JpaRepository<Product, Integer> {

	List<Product> findByProductNameContaining(String name);
	
	List<Product> findAllByProductType(ProductType productType);

	@Query("select count(p.productId) from Product p")
	Integer productCount();

	List<Product> findAll();

	//List<Product> findProductByProductTypeId(int id);
	

	

	
	
	
}
