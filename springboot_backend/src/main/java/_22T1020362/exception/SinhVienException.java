package _22T1020362.exception;

@SuppressWarnings("serial")
public class SinhVienException extends RuntimeException {

    public SinhVienException(String message) {
        super(message);
    }

    public SinhVienException(String message, Throwable cause) {
        super(message, cause);
    }
}
