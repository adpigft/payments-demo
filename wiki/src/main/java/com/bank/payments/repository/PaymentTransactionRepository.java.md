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

## Custom Method
| Method Signature                                   | Description                                                  |
|--------------------------------------------------|--------------------------------------------------------------|
| `Optional<PaymentTransaction> findByIdempotencyKey(String key)` | Retrieves a `PaymentTransaction` by its unique idempotency key, wrapped in an `Optional` to handle absence of a matching record. |

## Entity Managed
- `PaymentTransaction` (assumed to be a JPA entity representing a payment transaction)

## Insights
- The repository leverages Spring Data JPA to abstract database interactions, reducing boilerplate code.
- The custom finder method `findByIdempotencyKey` supports idempotency in payment processing, which is critical to avoid duplicate transactions.
- Returning an `Optional` for the custom query method promotes safe handling of potentially missing data.
- The interface contains only data structure declarations (repository methods) without any business logic implementation. The actual query execution is handled by Spring Data JPA at runtime.
