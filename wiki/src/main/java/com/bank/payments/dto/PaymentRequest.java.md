# PaymentRequest Class Documentation

## Overview
`PaymentRequest` is a data transfer object (DTO) used to encapsulate the details of a payment transaction request within a banking payment system.

## Package
`com.bank.payments.dto`

## Class Type
Data Structure (DTO) — contains only fields and their corresponding getters and setters, no business logic.

## Fields

| Field Name         | Type        | Description                                                                                  |
|--------------------|-------------|----------------------------------------------------------------------------------------------|
| `sourceAccount`    | `String`    | The account identifier from which the payment will be debited.                              |
| `destinationAccount` | `String`    | The account identifier to which the payment will be credited.                               |
| `amount`           | `BigDecimal`| The monetary amount to be transferred.                                                     |
| `currency`         | `String`    | The currency code (e.g., USD, EUR) of the payment amount.                                   |
| `type`             | `String`    | The type of payment. Possible values include: `QR`, `DOMESTIC`, `INTL`.                     |
| `remarks`          | `String`    | Optional remarks or notes related to the payment.                                          |
| `idempotencyKey`   | `String`    | A unique key to ensure idempotency of the payment request, preventing duplicate processing. |

## Methods

### Getters and Setters
Each field has a corresponding getter and setter method to access and modify the field values. These methods follow the standard JavaBean naming conventions.

| Method Name               | Description                                  |
|---------------------------|----------------------------------------------|
| `getSourceAccount()`       | Returns the source account identifier.       |
| `setSourceAccount(String)` | Sets the source account identifier.          |
| `getDestinationAccount()`  | Returns the destination account identifier.  |
| `setDestinationAccount(String)` | Sets the destination account identifier.   |
| `getAmount()`             | Returns the payment amount.                   |
| `setAmount(BigDecimal)`   | Sets the payment amount.                       |
| `getCurrency()`           | Returns the currency code.                     |
| `setCurrency(String)`     | Sets the currency code.                        |
| `getType()`               | Returns the payment type.                      |
| `setType(String)`         | Sets the payment type.                         |
| `getRemarks()`            | Returns the remarks.                           |
| `setRemarks(String)`      | Sets the remarks.                              |
| `getIdempotencyKey()`     | Returns the idempotency key.                   |
| `setIdempotencyKey(String)` | Sets the idempotency key.                      |

## Insights
- The use of `BigDecimal` for the `amount` field ensures precision in monetary calculations, which is critical in financial applications.
- The `type` field indicates the payment method or channel, which can be used to route or process the payment differently.
- The `idempotencyKey` is a key design feature to prevent duplicate payment processing, which is essential in distributed systems or when retrying requests.
- This class is designed purely as a data container without any validation or business logic, implying that validation and processing are handled elsewhere in the system.
