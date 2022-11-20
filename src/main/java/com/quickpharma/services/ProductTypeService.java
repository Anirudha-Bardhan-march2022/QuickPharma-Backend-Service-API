package com.quickpharma.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.quickpharma.entities.ProductType;

public interface ProductTypeService {
	ProductType findProductTypeById(int id);
	List<ProductType> findProductTypeAll();
	ProductType saveProductType(ProductType productType, MultipartFile thumbnail);
	boolean deleteProductTypeById(int id);
}
