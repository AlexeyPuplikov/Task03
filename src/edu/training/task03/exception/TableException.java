package edu.training.task03.exception;

public class TableException extends Exception {
    public TableException() {
        super();
    }
    public TableException(String message, Throwable cause) {
        super(message, cause);
    }
    public TableException(String message) {
        super(message);
    }
    public TableException(Throwable cause) {
        super(cause);
    }
}
