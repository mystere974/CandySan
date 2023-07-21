package com.candy.exception;

public class CommandeNonAutoriseeException  extends RuntimeException{

    public CommandeNonAutoriseeException(String message) {
        super(message);
    }
}
