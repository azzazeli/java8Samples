package oca.exception.retries;

public class AskForNewFilenameException extends Exception {

    public AskForNewFilenameException() {
    }

    public AskForNewFilenameException(String message) {
        super(message);
    }

    public AskForNewFilenameException(String message, Throwable cause) {
        super(message, cause);
    }

    public AskForNewFilenameException(Throwable cause) {
        super(cause);
    }

    public AskForNewFilenameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

