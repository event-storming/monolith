# monolith
참고:  
Order 와 product 는 N:1 (다대일) 관계이다.  


-- 주문 하기  
http localhost:8088/orders productId=1 quantity=3 customerId="1@uengine.org" customerName="홍길동" customerAddr="서울시"

-- 주문 후 변경된 상품 수량 확인  
http http://localhost:8088/orders/1/product  

-- 주문 후 delivery 내역중 order  확인  
http http://localhost:8088/deliveries  
http http://localhost:8088/orders/1/delivery  

-- 배송 완료하기  
http PATCH localhost:8088/deliveries/1 deliveryState=DeliveryCompleted


-- 주문 취소 하기
http PATCH localhost:8088/orders/1 state=OrderCancelled
