package com.example.template.delivery;


import com.example.template.Application;
import com.example.template.order.Order;
import com.example.template.product.ProductService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;
    private int quantity;
    private Long productId;
    private String productName;
    private String customerId;
    private String customerName;
    private String deliveryAddress;
    private String deliveryState;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "order_id", referencedColumnName = "deliveryId")
    private Order order;
//    private Long orderId;

    @PostPersist
    private void callProductApi() {
        // 상품 수량 변경 - 수량변경은 상품서비스에서 직접..
        ProductService productService = Application.applicationContext.getBean(ProductService.class);
        productService.decreaseStock(productId, quantity);
    }

//    @PostUpdate
//    private void deliveryUpdate(){
//        if( "OrderCancelled".equals(order.getState())){
//            // 상품 수량 변경
//            ProductService productService = Application.applicationContext.getBean(ProductService.class);
//            productService.increaseStock(productId, quantity);
//        }
//    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
