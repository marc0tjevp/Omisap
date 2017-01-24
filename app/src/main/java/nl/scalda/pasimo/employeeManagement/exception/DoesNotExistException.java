package nl.scalda.pasimo.employeeManagement.exception;

/**
 * TODO: Move to generic package
 */
public class DoesNotExistException extends RuntimeException {

    public DoesNotExistException() {
    }

    public DoesNotExistException(String message) {
        super(message);
    }

    public DoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoesNotExistException(Throwable cause) {
        super(cause);
    }

    public DoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
