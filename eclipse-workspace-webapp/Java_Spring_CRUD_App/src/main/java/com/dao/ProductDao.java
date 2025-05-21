package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//For saving a product
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	//For getting all product
	public List<Product> getAllProducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//Delete the single product
	@Transactional
	public void deleteProduct(int pId) {
		Product p = this.hibernateTemplate.load(Product.class, pId);
		this.hibernateTemplate.delete(p);
	}
	
	//Getting single product
	public Product getProduct(int pId) {
		return this.hibernateTemplate.get(Product.class, pId);
	}
}
