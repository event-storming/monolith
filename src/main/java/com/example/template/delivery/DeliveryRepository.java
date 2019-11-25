package com.example.template.delivery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findByOrderIdOrderByDeliveryIdDesc(Long orderId);

}
