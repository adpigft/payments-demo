# PaymentTransaction Data Structure Documentation

## Overview
`PaymentTransaction` is a Java entity class representing a payment transaction record in a banking payment system. It is mapped to the database table `payment_transactions` using JPA annotations.

---

## Entity Mapping
| Annotation               | Description                                  |
|-------------------------|----------------------------------------------|
| `@Entity`               | Marks the class as a JPA entity.             |
| `@Table(name = "payment_transactions")` | Specifies the database table name.        |
| `@Id`                   | Marks the primary key field.                  |
| `@GeneratedValue(strategy = GenerationType.IDENTITY)` | Specifies auto-increment strategy for the primary key. |

---

## Fields

| Field Name        | Type             | Description                                                                                  |
|-------------------|------------------|----------------------------------------------------------------------------------------------|
| `id`              | `Long`           | Unique identifier for the payment transaction (primary key).                                |
| `sourceAccount`   | `String`         | Account number or identifier from which the payment is made.                                |
| `destinationAccount` | `String`       | Account number or identifier to which the payment is sent.                                 |
| `amount`          | `BigDecimal`     | Monetary amount of the transaction.                                                        |
| `currency`        | `String`         | Currency code (e.g., USD, EUR) of the transaction amount.                                  |
| `type`            | `String`         | Type of the payment transaction (e.g., transfer, withdrawal).                              |
| `remarks`         | `String`         | Additional notes or comments related to the transaction.                                  |
| `status`          | `String`         | Current status of the transaction (e.g., pending, completed, failed).                      |
| `idempotencyKey`  | `String`         | Unique key to ensure idempotency of the transaction request.                              |
| `createdAt`       | `LocalDateTime`  | Timestamp when the transaction was created.                                               |

---

## Accessors and Mutators
The class provides standard getter and setter methods for all fields, allowing encapsulated access and modification of the transaction data.

---

## Insights
- The use of `BigDecimal` for `amount` ensures precision in financial calculations.
- `idempotencyKey` supports safe retry mechanisms by preventing duplicate transactions.
- `LocalDateTime` for `createdAt` captures the exact creation time, useful for auditing and tracking.
- The class is a pure data structure with no business logic implemented.
- JPA annotations facilitate ORM (Object-Relational Mapping) for seamless database integration.
