package hu.nye.progtech.foxandhounds.service.exception;

/**
 * Exception that should be thrown when a put operation fails.
 */
public class PutException extends RuntimeException {

    public PutException(String message) {
        super(message);
    }

}
