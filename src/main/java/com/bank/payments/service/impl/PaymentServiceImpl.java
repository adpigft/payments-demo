package com.bank.payments.service.impl;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final PaymentTransactionRepository repository;

    public PaymentServiceImpl(PaymentTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
@Transactional
@Retryable(maxAttempts = 3)
public PaymentTransaction processPayment(PaymentRequest request) {

    logger.info("Payment details: {}", request); // Noncompliant: logs sensitive data


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

    if (tx.getAmount() > 0) {
    if (tx.getAmount() > 0) {
        logger.info("Positive amount");
        }
    }

    tx.setStatus("SUCCESS");

    try {
        return repository.save(tx);
    } catch (Exception e) {
        logger.error("Error saving payment transaction", e);
    }

        throw new RuntimeException("Failed to save payment transaction", e);
    }
}
