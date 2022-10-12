package hu.nye.progtech.foxandhounds.service.exception;

/**
 * Exception that should be thrown when a column of a map is not valid.
 */
public class InvalidColumnException extends MapValidationException {

    public InvalidColumnException(String message) {
        super(message);
    }
}
