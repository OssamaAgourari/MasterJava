package org.example.ExceptionHandling.CustomExceptions;

/**
 * ============================================================
 *       CUSTOM EXCEPTIONS — COMPLETE GUIDE
 * ============================================================
 *
 * WHY CUSTOM EXCEPTIONS?
 * ----------------------
 *   - Express domain-specific errors clearly
 *   - Separate error types for different handling
 *   - Include additional context/fields
 *   - Better API design
 *
 * NAMING: Always end with "Exception" (e.g., InsufficientFundsException)
 *
 * HIERARCHY:
 * ----------
 *   Checked:   extend Exception
 *   Unchecked: extend RuntimeException (most common in modern Java)
 *
 * BEST PRACTICES:
 * ---------------
 *   1. Provide multiple constructors (message, cause, both)
 *   2. Add relevant fields for context
 *   3. Use unchecked unless caller must handle it
 *   4. Document with @throws javadoc
 *   5. Don't overuse — use standard exceptions when possible
 *
 * ============================================================
 */
public class CustomExceptions {

    // ── 1. Simple unchecked exception ─────────────────────────
    static class ValidationException extends RuntimeException {
        private final String field;
        private final Object rejectedValue;

        ValidationException(String field, Object rejectedValue, String message) {
            super(message);
            this.field = field;
            this.rejectedValue = rejectedValue;
        }

        String getField() { return field; }
        Object getRejectedValue() { return rejectedValue; }

        @Override
        public String toString() {
            return "ValidationException[field=" + field +
                   ", rejectedValue=" + rejectedValue +
                   ", message=" + getMessage() + "]";
        }
    }

    // ── 2. Checked exception with cause ──────────────────────
    static class DatabaseException extends Exception {
        private final String query;
        private final int errorCode;

        DatabaseException(String message, String query, int errorCode) {
            super(message);
            this.query = query;
            this.errorCode = errorCode;
        }

        DatabaseException(String message, String query, int errorCode, Throwable cause) {
            super(message, cause);
            this.query = query;
            this.errorCode = errorCode;
        }

        String getQuery()  { return query; }
        int getErrorCode() { return errorCode; }
    }

    // ── 3. Exception hierarchy ────────────────────────────────
    static class AppException extends RuntimeException {
        AppException(String message)             { super(message); }
        AppException(String message, Throwable c){ super(message, c); }
    }

    static class InsufficientFundsException extends AppException {
        private final double amount;
        private final double balance;

        InsufficientFundsException(double amount, double balance) {
            super(String.format("Insufficient funds: tried to withdraw %.2f but balance is %.2f", amount, balance));
            this.amount  = amount;
            this.balance = balance;
        }

        double getShortfall() { return amount - balance; }
    }

    static class AccountLockedException extends AppException {
        AccountLockedException(String accountId) {
            super("Account is locked: " + accountId);
        }
    }

    // ── 4. Using custom exceptions ────────────────────────────
    static class BankAccount {
        private double balance;
        private boolean locked;
        private final String id;

        BankAccount(String id, double balance) {
            this.id = id;
            this.balance = balance;
        }

        void withdraw(double amount) {
            if (locked)
                throw new AccountLockedException(id);
            if (amount <= 0)
                throw new ValidationException("amount", amount, "Withdrawal amount must be positive");
            if (amount > balance)
                throw new InsufficientFundsException(amount, balance);
            balance -= amount;
        }

        void lock()   { locked = true; }
        double getBalance() { return balance; }
    }

    // ── 5. Custom exception with enum error code ──────────────
    enum ErrorCode {
        INVALID_INPUT(400),
        UNAUTHORIZED(401),
        NOT_FOUND(404),
        INTERNAL_ERROR(500);

        final int httpStatus;
        ErrorCode(int s) { this.httpStatus = s; }
    }

    static class ApiException extends RuntimeException {
        private final ErrorCode errorCode;

        ApiException(ErrorCode errorCode, String message) {
            super(message);
            this.errorCode = errorCode;
        }

        ErrorCode getErrorCode() { return errorCode; }
        int getHttpStatus()      { return errorCode.httpStatus; }

        @Override
        public String toString() {
            return String.format("ApiException[%s(%d): %s]",
                errorCode, errorCode.httpStatus, getMessage());
        }
    }

    public static void main(String[] args) {
        // 1. ValidationException
        try {
            throw new ValidationException("email", "not-an-email", "Must be a valid email address");
        } catch (ValidationException e) {
            System.out.println("Field: " + e.getField());
            System.out.println("Value: " + e.getRejectedValue());
            System.out.println(e);
        }

        // 2. DatabaseException (checked — must catch or declare)
        try {
            throw new DatabaseException("Connection failed", "SELECT * FROM users", 1001);
        } catch (DatabaseException e) {
            System.out.printf("DB Error %d on query '%s': %s%n",
                e.getErrorCode(), e.getQuery(), e.getMessage());
        }

        // 3. Exception hierarchy
        BankAccount acc = new BankAccount("ACC001", 500.0);

        // InsufficientFunds
        try {
            acc.withdraw(1000.0);
        } catch (InsufficientFundsException e) {
            System.out.printf("Shortfall: %.2f%n", e.getShortfall()); // 500.0
        }

        // AccountLocked
        acc.lock();
        try {
            acc.withdraw(100.0);
        } catch (AccountLockedException e) {
            System.out.println(e.getMessage());
        }

        // Catch with parent type
        BankAccount acc2 = new BankAccount("ACC002", 200.0);
        try {
            acc2.withdraw(-50.0);
        } catch (AppException e) { // catches any AppException subclass
            System.out.println("App error: " + e.getMessage());
        }

        // 4. ApiException
        try {
            throw new ApiException(ErrorCode.NOT_FOUND, "User not found with id=42");
        } catch (ApiException e) {
            System.out.println(e);
            System.out.println("HTTP Status: " + e.getHttpStatus());
        }

        System.out.println("\n=== Custom Exception Best Practices ===");
        System.out.println("1. Name ends with 'Exception'");
        System.out.println("2. Extend RuntimeException (unchecked) for most cases");
        System.out.println("3. Include relevant fields for debugging");
        System.out.println("4. Provide message + cause constructors");
        System.out.println("5. Build exception hierarchies for fine-grained catching");
    }
}
