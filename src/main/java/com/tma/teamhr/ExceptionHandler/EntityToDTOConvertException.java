package com.tma.teamhr.ExceptionHandler;

public class EntityToDTOConvertException extends RuntimeException{
    public EntityToDTOConvertException(String message){
        super(message);
    }
}
