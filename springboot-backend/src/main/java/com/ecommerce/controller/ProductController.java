package com.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	// get all products
	@GetMapping("/Products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	// create product rest api
		@PostMapping("/Products")
		public Product createProduct(@RequestBody Product product) {
			return productRepository.save(product);
		}
		
		// get product by id rest api
		@GetMapping("/Products/{pid}")
		public ResponseEntity<Product> getProductById(@PathVariable Integer pid) {
			Product product = productRepository.findById(pid)
					.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + pid));
			return ResponseEntity.ok(product);
		}
		
		// update product rest api
		
		@PutMapping("/Products/{pid}")
		public ResponseEntity<Product> updateProduct(@PathVariable Integer pid, @RequestBody Product productDetails){
			Product product = productRepository.findById(pid)
					.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + pid));
			
			product.setPbrand(productDetails.getPbrand());
			product.setPname(productDetails.getPname());
			product.setPrate(productDetails.getPrate());
			
			Product updatedProduct = productRepository.save(product);
			return ResponseEntity.ok(updatedProduct);
		}
		
		// delete product rest api
		@DeleteMapping("/Products/{pid}")
		public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Integer pid){
			Product product = productRepository.findById(pid)
					.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + pid));
			
			productRepository.delete(product);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
