package hu.nye.progtech.foxandhounds.service.exception;

/**
 * Exception that should be thrown when the reading of a map fails.
 */
public class MapReadException extends RuntimeException {

    public MapReadException(String message) {
        super(message);
    }
}
