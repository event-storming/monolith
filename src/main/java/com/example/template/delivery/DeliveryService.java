package com.example.template.delivery;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name ="delivery", url="${api.url.delivery}")
public interface DeliveryService {

//    @RequestMapping(method = RequestMethod.POST, value = "/deliveries", consumes = "application/json")
    void startDelivery(Delivery delivery);


//    void updateDelivery(Long deliveryId, Delivery delivery);
}
