# PaymentController Documentation

## Overview
`PaymentController` is a Spring REST controller responsible for handling payment transaction requests. It exposes an endpoint to process payment transactions by delegating the business logic to the `PaymentService`.

---

## Package
`com.bank.payments.controller`

---

## Annotations
| Annotation           | Description                                                  |
|----------------------|--------------------------------------------------------------|
| `@RestController`    | Marks the class as a REST controller, combining `@Controller` and `@ResponseBody`. |
| `@RequestMapping`    | Maps HTTP requests to `/api/payments` base URL.              |
| `@PostMapping`       | Maps HTTP POST requests to the `makePayment` method.         |
| `@Operation`         | Provides OpenAPI/Swagger metadata for the endpoint.          |

---

## Dependencies
| Dependency          | Purpose                                                      |
|---------------------|--------------------------------------------------------------|
| `PaymentService`    | Service layer component that contains the business logic for processing payments. |
| `PaymentRequest`    | DTO representing the payment request payload.                |
| `PaymentTransaction`| Model representing the result of a processed payment.        |

---

## Constructor
```java
public PaymentController(PaymentService paymentService)
```
- Injects the `PaymentService` dependency.

---

## Endpoint: `makePayment`
```java
@PostMapping
public ResponseEntity<PaymentTransaction> makePayment(
        @RequestBody PaymentRequest request,
        @RequestHeader("Idempotency-Key") String key)
```

### Description
Processes a payment transaction based on the provided payment request and an idempotency key.

### Parameters
| Parameter           | Source          | Description                                  |
|---------------------|-----------------|----------------------------------------------|
| `request`           | Request Body    | Contains payment details to be processed.    |
| `key`               | Request Header  | Idempotency key to prevent duplicate processing. |

### Behavior
- Sets the idempotency key on the `PaymentRequest`.
- Calls `paymentService.processPayment(request)` to process the payment.
- Returns the processed `PaymentTransaction` wrapped in an HTTP 200 OK response.

### Notes
- There is a code snippet with a potential `NullPointerException`:
  ```java
  String value = null;
  if (value.equals("test")) {
      // do nothing
  }
  ```
  This appears to be a SonarQube bug example or placeholder and does not affect the actual payment processing logic.

---

## Insights
- The controller cleanly separates HTTP request handling from business logic by delegating to `PaymentService`.
- The use of an idempotency key header is a good practice to avoid duplicate payment processing.
- The presence of a potential `NullPointerException` in the code is likely a placeholder or test code and should be removed or fixed to avoid runtime errors.
- The controller uses OpenAPI annotations to provide API documentation metadata, facilitating API client generation and documentation.

---

## Summary Table

| Aspect               | Details                                      |
|----------------------|----------------------------------------------|
| Base URL             | `/api/payments`                              |
| HTTP Method          | POST                                         |
| Request Body         | `PaymentRequest`                             |
| Request Header       | `Idempotency-Key`                            |
| Response             | `PaymentTransaction` wrapped in `ResponseEntity` |
| Exception Handling   | Not explicitly handled in this controller   |
| External Dependencies| `PaymentService`                             |
