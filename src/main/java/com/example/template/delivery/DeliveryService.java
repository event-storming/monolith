package com.example.template.delivery;

import com.example.template.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    /**
     * 배송 시작
     */
    public void startDelivery(Order order){
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
    public void completeDelivery(Order order){
        Delivery delivery = order.getDelivery();
        delivery.setDeliveryState(DeliveryStatus.DeliveryCompleted.name());
        deliveryRepository.save(delivery);
    }

    /**
     * 배송 취소
     */
    public void cancelDelivery(Order order){
        Delivery delivery = order.getDelivery();
        delivery.setDeliveryState(DeliveryStatus.DeliveryCancelled.name());
        deliveryRepository.save(delivery);
    }

}
