package exceptions;

public class PropertiesParsingException extends RuntimeException {
    public PropertiesParsingException(String message) {
        super (message);
    }
    public PropertiesParsingException (String message, Throwable cause) {
        super (message, cause);
    }
}
