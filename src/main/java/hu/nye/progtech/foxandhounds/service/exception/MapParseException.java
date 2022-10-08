package hu.nye.progtech.foxandhounds.service.exception;

/**
 * Exception that should be thrown when the parsing of a map fails.
 */
public class MapParseException extends RuntimeException {

    public MapParseException(String message) {
        super(message);
    }
}
