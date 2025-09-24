# PaymentRequest Class Documentation

## Overview
The `PaymentRequest` class is a data structure representing a payment transaction request in a banking payment system. It encapsulates all necessary information required to initiate a payment, including account details, amount, currency, payment type, and additional metadata.

---

## Package
`com.bank.payments.dto`

---

## Fields

| Field Name        | Type        | Description                                                                                  |
|-------------------|-------------|----------------------------------------------------------------------------------------------|
| `sourceAccount`   | `String`    | The account number or identifier from which the payment will be debited.                     |
| `destinationAccount` | `String` | The account number or identifier to which the payment will be credited.                      |
| `amount`          | `BigDecimal`| The monetary amount to be transferred.                                                      |
| `currency`        | `String`    | The currency code (e.g., USD, EUR) for the payment amount.                                  |
| `type`            | `String`    | The type of payment. Possible values include: `QR`, `DOMESTIC`, `INTL`.                      |
| `remarks`         | `String`    | Optional remarks or notes related to the payment.                                           |
| `idempotencyKey`  | `String`    | A unique key to ensure idempotency of the payment request, preventing duplicate processing. |

---

## Methods

### Getters and Setters
The class provides standard getter and setter methods for all fields, allowing encapsulated access and modification of the payment request data.

| Method                  | Description                                  |
|-------------------------|----------------------------------------------|
| `getSourceAccount()`    | Returns the source account identifier.       |
| `setSourceAccount(String)` | Sets the source account identifier.        |
| `getDestinationAccount()` | Returns the destination account identifier. |
| `setDestinationAccount(String)` | Sets the destination account identifier. |
| `getAmount()`           | Returns the payment amount.                   |
| `setAmount(BigDecimal)` | Sets the payment amount.                       |
| `getCurrency()`         | Returns the currency code.                     |
| `setCurrency(String)`   | Sets the currency code.                        |
| `getType()`             | Returns the payment type.                      |
| `setType(String)`       | Sets the payment type.                         |
| `getRemarks()`          | Returns the remarks.                           |
| `setRemarks(String)`    | Sets the remarks.                              |
| `getIdempotencyKey()`   | Returns the idempotency key.                   |
| `setIdempotencyKey(String)` | Sets the idempotency key.                   |

---

## Insights

- **Idempotency Support:** The presence of `idempotencyKey` indicates that the system supports idempotent payment requests, which is critical for avoiding duplicate transactions in distributed systems.
- **Payment Type Flexibility:** The `type` field supports multiple payment types (`QR`, `DOMESTIC`, `INTL`), allowing the class to be used in various payment scenarios.
- **Monetary Precision:** Usage of `BigDecimal` for the `amount` field ensures precision in financial calculations, avoiding floating-point errors.
- **Data Structure Nature:** This class is purely a data transfer object (DTO) with no business logic, designed for encapsulating payment request data.
