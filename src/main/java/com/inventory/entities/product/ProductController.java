package com.inventory.entities.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventory.entities.category.Category;
import com.inventory.entities.category.CategoryRepository;



@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@GetMapping("/products/new")
	public String showNewProductForm(Model model) {
		java.util.List<Category> listCategories = categoryRepo.findAll();
		model.addAttribute("product",new Product());
		model.addAttribute("listCategories", listCategories);
		
		return "product_form";
	}
	
	@PostMapping("/products/save")
	public String saveProduct(Product product) {
		productRepo.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		
		List<Product>listProducts=productRepo.findAll();
		model.addAttribute("listProducts", listProducts);
		
		return "products";
	}
	
	@GetMapping("/products/edit/{id}")
	public String showEditProductForm(@PathVariable("id") Integer id, Model model) {
		Product product = productRepo.findById(id).get();
		model.addAttribute("product", product);
		
		java.util.List<Category> listCategories = categoryRepo.findAll();
		model.addAttribute("listCategories", listCategories);
		
		return "product_form";
	}
	
	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, Model model) {
		productRepo.deleteById(id);
		
		return "redirect:/products";
		
	}
	

}
