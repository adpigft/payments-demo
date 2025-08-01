# PaymentController Documentation

## Overview
`PaymentController` is a Spring REST controller responsible for handling payment transaction requests. It exposes an endpoint to process payments by delegating the business logic to the `PaymentService`.

---

## Package
`com.bank.payments.controller`

---

## Annotations
| Annotation           | Description                                                  |
|----------------------|--------------------------------------------------------------|
| `@RestController`    | Marks the class as a REST controller, combining `@Controller` and `@ResponseBody`. |
| `@RequestMapping`    | Maps HTTP requests to `/api/payments` base path.             |
| `@PostMapping`       | Maps HTTP POST requests to the `makePayment` method.         |
| `@Operation`         | Provides OpenAPI/Swagger metadata for the endpoint.           |

---

## Dependencies
| Dependency          | Purpose                                                      |
|---------------------|--------------------------------------------------------------|
| `PaymentService`    | Service layer component that contains the business logic for processing payments. |
| `PaymentRequest`    | DTO representing the payment request payload.                |
| `PaymentTransaction`| Model representing the result of a payment transaction.      |

---

## Constructor
```java
public PaymentController(PaymentService paymentService)
```
- Injects the `PaymentService` dependency.

---

## Endpoints

### `POST /api/payments`

#### Description
Processes a payment transaction.

#### Method Signature
```java
public ResponseEntity<PaymentTransaction> makePayment(
    @RequestBody PaymentRequest request,
    @RequestHeader("Idempotency-Key") String key)
```

#### Parameters
| Parameter           | Source          | Description                                  |
|---------------------|-----------------|----------------------------------------------|
| `request`           | Request Body    | Contains payment details to be processed.    |
| `key`               | Request Header  | Idempotency key to ensure request uniqueness.|

#### Behavior
- Sets the idempotency key on the `PaymentRequest`.
- Calls `paymentService.processPayment(request)` to process the payment.
- Returns the processed `PaymentTransaction` wrapped in a `ResponseEntity` with HTTP 200 OK.

#### Notes
- There is a code snippet with a potential `NullPointerException`:
  ```java
  String value = null;
  if (value.equals("test")) {
      // do nothing
  }
  ```
  This is a known Sonar bug and does not affect the payment processing logic.

---

## Insights
- The controller follows RESTful principles and uses Spring annotations effectively.
- The idempotency key is enforced via a request header, which is a good practice to prevent duplicate payment processing.
- The presence of a deliberate `NullPointerException` risk in the code is likely for demonstration or testing purposes and should be removed or handled properly in production.
- The controller delegates all business logic to the `PaymentService`, maintaining separation of concerns.
- OpenAPI annotations improve API documentation and integration with tools like Swagger UI.

---

## Summary Table

| Aspect               | Details                                                      |
|----------------------|--------------------------------------------------------------|
| Base URL             | `/api/payments`                                              |
| HTTP Method          | POST                                                        |
| Request Body         | `PaymentRequest`                                            |
| Request Header       | `Idempotency-Key`                                           |
| Response             | `PaymentTransaction` wrapped in `ResponseEntity`           |
| Exception Handling   | No explicit handling; potential NPE in code snippet noted   |
| External Dependencies| `PaymentService`, DTOs, and models from the `com.bank.payments` package |
