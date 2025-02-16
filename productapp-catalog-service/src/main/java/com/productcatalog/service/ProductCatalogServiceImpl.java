package com.productcatalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productcatalog.model.Product;
import com.productcatalog.util.ProductDetails;
@Service
public class ProductCatalogServiceImpl implements IProductCatalogService{
	@Autowired
    private ProductDetails productDetails;
    
	@Override
	public List<Product> getAll() {
		
		return productDetails.showProducts();
	}

	@Override
	public List<Product> getByCategory(String category) {
		List<Product> products=productDetails.showProducts();
		//covert to stream,filter ,covert to list
		return products.stream()
				.filter(product -> product.getCategory().equals(category))
		        .toList();
		        
	}

	@Override
	public Optional<Product> getById(int productId) {
		
		return productDetails.showProducts()
				.stream()
				.filter(product->product.getProductId()==productId)
				.findFirst();
	}

}
