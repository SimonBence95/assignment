package hu.nye.progtech.foxandhounds.service.exception;

/**
 * Exception that should be thrown when the validation of a map fails.
 */
public class MapValidationException extends RuntimeException {

    public MapValidationException(String message) {
        super(message);
    }
}
