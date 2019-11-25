package com.example.template.order;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "No Available stock!")
public class OrderException extends RuntimeException {
    public OrderException(String message) {
        super(message);
    }
}
