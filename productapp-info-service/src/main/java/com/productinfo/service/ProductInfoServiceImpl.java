package com.productinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productinfo.model.Product;

@Service
public class ProductInfoServiceImpl implements IProductInfoService {
	//from here call the catalog service
	//call the microservice synchronously using RestTemplate
	
	@Autowired
	RestTemplate restTemplate;
	
	String BASEURL="http://PRODUCT-CATALOG/catalog-service/v1/productcatalog";
	
	@Override
	public List<Product> getAllProductInfo() {
		List<Product> products= restTemplate.getForObject(BASEURL,List.class);
		return products;
	}

	@Override
	public List<Product> getProductInfoByCategory(String category) {
//		http://localhost:8081/catalog-service/v1/productcatalog/category/Sports
		String url=BASEURL.concat("/category/").concat(category);
		return restTemplate.getForObject(url, List.class);
	}

	@Override
	public Product getProductInfoById(int prodId) {
		String url=BASEURL.concat("/productId/")+prodId;
		return restTemplate.getForObject(url, Product.class);
	}

}
