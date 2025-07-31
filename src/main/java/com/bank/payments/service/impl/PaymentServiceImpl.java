package com.bank.payments.service.impl;

import java.time.LocalDateTime;

import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.payments.dto.PaymentRequest;
import com.bank.payments.exception.PaymentAlreadyProcessedException;
import com.bank.payments.model.PaymentTransaction;
import com.bank.payments.repository.PaymentTransactionRepository;
import com.bank.payments.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentTransactionRepository repository;

    public PaymentServiceImpl(PaymentTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    @Retryable(maxAttempts = 3)
    public PaymentTransaction processPayment(PaymentRequest request) {
        repository.findByIdempotencyKey(request.getIdempotencyKey())
            .ifPresent(tx -> { throw new PaymentAlreadyProcessedException("Duplicate payment"); });

        PaymentTransaction tx = new PaymentTransaction();
        tx.setSourceAccount(request.getSourceAccount());
        tx.setDestinationAccount(request.getDestinationAccount());
        tx.setAmount(request.getAmount());
        tx.setCurrency(request.getCurrency());
        tx.setType(request.getType());
        tx.setRemarks(request.getRemarks());
        tx.setStatus("PROCESSING");
        tx.setIdempotencyKey(request.getIdempotencyKey());
        tx.setCreatedAt(LocalDateTime.now());

        tx.setStatus("SUCCESS");

        return repository.save(tx);
    }
}
