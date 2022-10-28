package com.ssafy.cafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.ssafy.cafe.model.Product;
import com.ssafy.cafe.model.service.ProductService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class ProductRestController {

	private final ProductService productService;

	@Autowired
	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/product")
	public ResponseEntity<?> productList() {
		try {
			List<Product> products = productService.selectAll(null);

			if (products != null && !products.isEmpty()) {
				return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@PostMapping("/product")
	public ResponseEntity<?> productRegister(@RequestBody Product product) {
		try {
			productService.insert(product);
			List<Product> products = productService.selectAll(null);

			if (products != null && !products.isEmpty()) {
				return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@PutMapping("/product")
	public ResponseEntity<?> productModify(@RequestBody Product product) {
		try {
			productService.update(product);
			List<Product> products = productService.selectAll(null);

			if (products != null && !products.isEmpty()) {
				return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/product/{productid}")
	// 리턴되는 String이 view의 이름? 경로? 가 아니라 데이터 그 자체라는 뜻 (@ResponseBody)를 붙여야 되는데 컨트롤러
	// 자체를 RestController라고 하면?
	public ResponseEntity<?> productDelete(@PathVariable("productid") Integer productId) {
		try {

			productService.delete(productId);
			List<Product> products = productService.selectAll(null);

			if (products != null && !products.isEmpty()) {
				return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@GetMapping("/product/{userid}")
	// 리턴되는 String이 view의 이름? 경로? 가 아니라 데이터 그 자체라는 뜻 (@ResponseBody)를 붙여야 되는데 컨트롤러
	// 자체를 RestController라고 하면?
	public ResponseEntity<?> productView(@PathVariable("userid") Integer productId) {
		try {

			Product product = productService.select(productId);

			if (product != null) {
				return new ResponseEntity<Product>(product, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
