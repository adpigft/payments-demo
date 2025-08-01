# PaymentTransactionRepository

## Overview
This interface defines a repository for managing `PaymentTransaction` entities. It extends the Spring Data JPA `JpaRepository` interface, providing CRUD operations and additional JPA-related methods for the `PaymentTransaction` entity with a primary key of type `Long`.

## Package
`com.bank.payments.repository`

## Interface
`PaymentTransactionRepository`

### Extends
- `JpaRepository<PaymentTransaction, Long>`

This inheritance provides standard data access methods such as:
- `save()`
- `findById()`
- `findAll()`
- `delete()`
- and others

### Custom Method
| Method Signature                              | Description                                                  |
|----------------------------------------------|--------------------------------------------------------------|
| `Optional<PaymentTransaction> findByIdempotencyKey(String key)` | Retrieves a `PaymentTransaction` entity by its unique idempotency key, wrapped in an `Optional` to handle absence of a matching record. |

## Entity Managed
- `PaymentTransaction` (from package `com.bank.payments.model`)

## Insights
- The repository leverages Spring Data JPA to abstract database interactions, reducing boilerplate code.
- The custom finder method `findByIdempotencyKey` suggests that the `PaymentTransaction` entity has a unique field `idempotencyKey` used to prevent duplicate processing of the same payment transaction.
- Returning an `Optional` for the custom finder method promotes safe handling of potentially missing data, avoiding null checks.
- This interface contains only data access method declarations and no business logic.
