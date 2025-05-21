package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.ProductDao;
import com.model.Product;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;

	@RequestMapping("/")
	public String home(Model m){
		List<Product> allProducts = productDao.getAllProducts();
		m.addAttribute("product", allProducts);
		return "index";
	}

	//show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title","Add Product");
		return "add_product_form";
	}
	
	//handle add product form
	@RequestMapping(value = "/handle-product", method = RequestMethod.POST )
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		productDao.createProduct(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//delete handler 
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId ,HttpServletRequest request) {
		productDao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int pId,Model m) {
		Product product = productDao.getProduct(pId);
		m.addAttribute("product", product);
		return "update_form";
	}
}
