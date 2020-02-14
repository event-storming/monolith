package com.example.template.product;

import com.example.template.order.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public void decreaseStock(Long productId, int quantity) {

        /**
         * 주문이 발생시, 수량을 줄인다.
         */
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = productOptional.get();
        product.setStock(product.getStock() - quantity);

        productRepository.save(product);

    }

    public void increaseStock(Long productId, int quantity) {
        /**
         * 주문 취소시, 수량을 늘인다
         */
        Optional<Product> productOptional = productRepository.findById(productId);
        Product product = productOptional.get();
        product.setStock(product.getStock() + quantity);

        productRepository.save(product);
    }

    /**
     * 상품 조회
     */
    public Product getProductById(Long id){

        Optional<Product> productOptional = productRepository.findById(id);
        Product product = productOptional.get();

        return product;
    }

    public Product save(String data){
        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        try {
            product = mapper.readValue(data, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<ProductOption> productOptions = product.getProductOptions();
        for(ProductOption p : productOptions){
            p.setProduct(product);
        }

        return productRepository.save(product);
    }
}
