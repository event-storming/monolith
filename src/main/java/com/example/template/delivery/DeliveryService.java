package com.example.template.delivery;

public interface DeliveryService {
    void startDelivery(Delivery delivery);
    void completeDelivery(Long deliveryId);
    void cancelDelivery(Long deliveryId);
}
