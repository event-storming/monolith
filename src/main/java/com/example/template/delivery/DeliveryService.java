package com.example.template.delivery;

import com.example.template.order.Order;

public interface DeliveryService {
    void startDelivery(Delivery delivery);
    void completeDelivery(Long deliveryId);
    void cancelDelivery(Long deliveryId);
}
