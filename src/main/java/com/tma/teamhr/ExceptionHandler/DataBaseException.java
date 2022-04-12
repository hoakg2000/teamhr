package com.tma.teamhr.ExceptionHandler;

public class DataBaseException extends RuntimeException{
    public DataBaseException(String message){
        super(message);
    }
}
