package com.c1331tjava.ServiceApp.exception;

/**
 * UserAlreadyExistException is a custom exception class that extends the CustomedHandler exception.
 * It represents an exception that is thrown when a user already exists.
 */
public class UserAlreadyExistException extends CustomedHandler {

    /**
     * Constructs a new UserAlreadyExistException object with the given error message.
     *
     * @param message The error message associated with the exception.
     */
    public UserAlreadyExistException(String message) {
        super(message);
    }

    /**
     * Generates a string representation of the UserAlreadyExistException object.
     * Overrides the toString method to return the combination of the error message and the associated date.
     *
     * @return A string representation containing the error message and the date.
     */
    @Override
    public String toString() {
        return super.getMessage() + " " + super.getDate();
    }
}

