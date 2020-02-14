package com.example.template.delivery;

import com.example.template.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService{

    @Autowired
    DeliveryRepository deliveryRepository;

    /**
     * 배송 시작
     */
    public void startDelivery(Delivery delivery){
        deliveryRepository.save(delivery);
    }

    /**
     * 배송 완료
     */
    public void completeDelivery(Long deliveryId){
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(deliveryId);
        Delivery delivery = deliveryOptional.get();
        delivery.setDeliveryState(DeliveryStatus.DeliveryCompleted.name());
        deliveryRepository.save(delivery);
    }

    /**
     * 배송 취소
     */
    public void cancelDelivery(Long deliveryId){
        Optional<Delivery> deliveryOptional = deliveryRepository.findById(deliveryId);
        Delivery delivery = deliveryOptional.get();
        delivery.setDeliveryState(DeliveryStatus.DeliveryCancelled.name());
        deliveryRepository.save(delivery);
    }

}
