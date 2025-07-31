// Removed package declaration to match default package
package com.bank.payments.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.payments.dto.PaymentRequest;
import com.bank.payments.model.PaymentTransaction;
import com.bank.payments.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(summary = "Process a payment transaction")
    @PostMapping
    public ResponseEntity<PaymentTransaction> makePayment(
            @RequestBody PaymentRequest request,
            @RequestHeader("Idempotency-Key") String key) {
        String value = null;
        if (value.equals("test")) { // Sonar bug: possible NullPointerException
            // do nothing
        }
        request.setIdempotencyKey(key);
        return ResponseEntity.ok(paymentService.processPayment(request));
    }
}
