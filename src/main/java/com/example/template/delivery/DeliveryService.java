package com.example.template.delivery;

public interface DeliveryService {
    void startDelivery(Delivery delivery);
    void updateDelivery(Long deliveryId, Delivery delivery);
}
