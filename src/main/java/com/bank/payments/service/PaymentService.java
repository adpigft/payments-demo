package com.bank.payments.service;

import com.bank.payments.dto.PaymentRequest;
import com.bank.payments.model.PaymentTransaction;

public interface PaymentService {
    PaymentTransaction processPayment(PaymentRequest request);
}
