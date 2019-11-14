package fr.dojo.exception;

public class UserException extends Exception {

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Exception e) {
        super(message, e);
    }
}
