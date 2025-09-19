# PaymentRequest Class Documentation

## Overview
`PaymentRequest` is a data transfer object (DTO) used to encapsulate the details of a payment transaction request within a banking payment system.

## Package
`com.bank.payments.dto`

## Class Type
Data Structure (DTO)

## Fields

| Field Name         | Type        | Description                                                                                  |
|--------------------|-------------|----------------------------------------------------------------------------------------------|
| `sourceAccount`    | `String`    | The account identifier from which the payment will be debited.                              |
| `destinationAccount` | `String`  | The account identifier to which the payment will be credited.                               |
| `amount`           | `BigDecimal`| The monetary amount to be transferred.                                                      |
| `currency`         | `String`    | The currency code (e.g., USD, EUR) of the payment amount.                                   |
| `type`             | `String`    | The type of payment, with possible values: `QR`, `DOMESTIC`, `INTL`.                        |
| `remarks`          | `String`    | Optional remarks or notes related to the payment.                                          |
| `idempotencyKey`   | `String`    | A unique key to ensure idempotency of the payment request, preventing duplicate processing. |

## Methods

### Getters and Setters
The class provides standard getter and setter methods for all fields, allowing encapsulated access and modification of the payment request data.

| Method                  | Description                                  |
|-------------------------|----------------------------------------------|
| `getSourceAccount()`    | Returns the source account identifier.       |
| `setSourceAccount(String)` | Sets the source account identifier.         |
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

## Insights
- The use of `BigDecimal` for the `amount` field ensures precision in monetary calculations, which is critical in financial applications.
- The `type` field indicates the payment method or channel, which can be used to route or process the payment differently.
- The `idempotencyKey` is a crucial feature for safely handling retries of payment requests without causing duplicate transactions.
- This class does not contain any business logic; it serves purely as a container for payment request data.
