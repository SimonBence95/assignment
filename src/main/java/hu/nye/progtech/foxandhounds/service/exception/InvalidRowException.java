package hu.nye.progtech.foxandhounds.service.exception;

/**
 * Exception that should be thrown when a row of a map is not valid.
 */
public class InvalidRowException extends MapValidationException {
    public InvalidRowException(String message) {
        super(message);
    }
}
