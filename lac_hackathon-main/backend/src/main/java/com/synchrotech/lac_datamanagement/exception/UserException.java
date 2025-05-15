package com.synchrotech.lac_datamanagement.exception;

public class UserException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        return "User not found";
    }

    public static String UserAlreadyExistsException() {
        return "User with entered email already exists";
    }

    public static String IncorrectPasswordException() {
        return "Incorrect Password";
    }

    public static String UserEmailNotVerified() {
        return "User email is not verified";
    }
}
