package com.example.dw_1.exception;

public class InvalidCredentialException extends Exception{
    public InvalidCredentialException() {
        super();
    }
    public InvalidCredentialException(String message){
        super(message);
    }
}
