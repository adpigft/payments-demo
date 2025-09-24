# PaymentAlreadyProcessedException

## Overview
`PaymentAlreadyProcessedException` is a custom unchecked exception class used to indicate that a payment has already been processed. It extends `RuntimeException`, allowing it to be thrown during the normal operation of the Java Virtual Machine without the need for explicit handling.

## Package
`com.bank.payments.exception`

## Class Definition
| Class Name                    | Extends          | Description                                      |
|------------------------------|------------------|------------------------------------------------|
| PaymentAlreadyProcessedException | RuntimeException | Signals that a payment has already been processed |

## Constructor
| Constructor Signature                          | Description                                  |
|-----------------------------------------------|----------------------------------------------|
| `PaymentAlreadyProcessedException(String message)` | Creates a new exception instance with a detailed message explaining the error. |

## Usage
This exception is intended to be thrown when an operation attempts to process a payment that has already been completed, preventing duplicate processing.

## Insights
- Extending `RuntimeException` means this exception is unchecked, so it does not require mandatory try-catch blocks or throws declarations.
- The class is minimalistic, focusing solely on conveying the error message.
- This design supports clear error signaling in payment processing workflows, improving error handling and debugging.
