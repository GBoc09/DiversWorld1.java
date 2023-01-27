package com.example.dw_1.exception;

public class NotExistantException  extends Exception{
    public NotExistantException(){
        super();
    }
    public NotExistantException(String error){
        super(error);
    }
}
