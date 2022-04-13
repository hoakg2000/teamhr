package com.tma.teamhr.ExceptionHandler;

public class UniqueEntityException extends RuntimeException{
    public UniqueEntityException(String message){
        super(message);
    }
}
