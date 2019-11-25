package com.example.template.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{productId}")
    Product productStockCheck(@PathVariable(value = "productId") Long productId) {
        return  this.productService.getProductById(productId);
    }

    @PostMapping("/product")
    Product productInsert(@RequestBody String data) {
        System.out.println(data);
        return this.productService.save(data);
    }
}
