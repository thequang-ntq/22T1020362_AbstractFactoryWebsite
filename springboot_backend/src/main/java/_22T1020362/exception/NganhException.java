package _22T1020362.exception;

@SuppressWarnings("serial")
public class NganhException extends RuntimeException {

    public NganhException(String message) {
        super(message);
    }

    public NganhException(String message, Throwable cause) {
        super(message, cause);
    }
}