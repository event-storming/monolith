package com.example.template.product;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    int price;
    int stock;
    String imageUrl;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<ProductOption> productOptions = new ArrayList<ProductOption>();

    @PostPersist @PostUpdate
    private void publishStart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<ProductOption> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOption> productOptions) {
        this.productOptions = productOptions;
    }

    public void addProductOptions(ProductOption productOption){
        productOptions.add(productOption);
        productOption.setProduct(this);
    }
}
