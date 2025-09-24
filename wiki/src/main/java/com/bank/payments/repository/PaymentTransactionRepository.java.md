# PaymentTransactionRepository

## Overview
This interface defines a repository for managing `PaymentTransaction` entities. It extends the Spring Data JPA `JpaRepository` interface, providing CRUD operations and additional JPA-related methods for the `PaymentTransaction` entity.

## Package
`com.bank.payments.repository`

## Interface
`PaymentTransactionRepository`

### Extends
- `JpaRepository<PaymentTransaction, Long>`

This extension provides standard data access methods such as:
- `save()`
- `findById()`
- `findAll()`
- `delete()`
- and others for the `PaymentTransaction` entity with a primary key of type `Long`.

### Custom Method
| Method Signature                              | Description                                                  |
|----------------------------------------------|--------------------------------------------------------------|
| `Optional<PaymentTransaction> findByIdempotencyKey(String key)` | Retrieves a `PaymentTransaction` by its unique idempotency key, wrapped in an `Optional` to handle absence of a matching record. |

## Entity Managed
- `PaymentTransaction` (from package `com.bank.payments.model`)

## Insights
- The repository leverages Spring Data JPA to abstract database interactions, reducing boilerplate code.
- The custom method `findByIdempotencyKey` supports idempotency in payment transactions, which is critical to avoid duplicate processing of the same payment request.
- Returning an `Optional` allows for safe handling of cases where no transaction matches the given idempotency key, promoting null-safety.
- This interface contains only data access method declarations and no business logic.
