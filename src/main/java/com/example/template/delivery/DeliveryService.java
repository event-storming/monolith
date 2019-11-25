package com.example.template.delivery;

import com.example.template.order.Order;
import com.example.template.order.OrderRepository;
import com.example.template.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    OrderRepository orderRepository;

    /**
     * 배송 시작
     */
    public void onDeliveryStart(Order order){
        Delivery delivery = new Delivery();
        delivery.setQuantity(order.getQuantity());
        delivery.setProductName(order.getProductName());
        delivery.setDeliveryAddress(order.getCustomerAddr());
        delivery.setCustomerId(order.getCustomerId());
        delivery.setCustomerName(order.getCustomerName());
        delivery.setDeliveryState(DeliveryStatus.DeliveryStarted.name());
        delivery.setOrder(order);
        deliveryRepository.save(delivery);

    }

    /**
     * 배송 완료
     */
    public void onDeliveryComplete(Long orderId){
        Delivery delivery = deliveryRepository.findById(orderId).get();
        delivery.setDeliveryState(DeliveryStatus.DeliveryCompleted.name());
        deliveryRepository.save(delivery);
    }

    /**
     * 배송 취소
     */
    public void onOrderCancel(Order order){
        Delivery delivery = order.getDelivery();
        delivery.setDeliveryState(DeliveryStatus.DeliveryCancelled.name());
        deliveryRepository.save(delivery);
    }

}
