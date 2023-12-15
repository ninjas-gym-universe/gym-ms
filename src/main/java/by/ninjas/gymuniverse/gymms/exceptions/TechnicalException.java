package by.ninjas.gymuniverse.gymms.exceptions;

/**
 * Represent technical exception in the application.
 *
 * @author Artyom Drobysh (artyom.drobysh96@gmail.com)
 * @version 0.2.0
 * @since 0.2.0
 */
public class TechnicalException extends RuntimeException {

    public TechnicalException() {}

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
