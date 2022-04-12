package com.tma.teamhr.ExceptionHandler;

import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<ResponseDTO> handleApiRequestException(ApiRequestException e){
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {UniqueEntityException.class})
    public ResponseEntity<ResponseDTO> handleUniqueEntityException(UniqueEntityException e){
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EntityToDTOConvertException.class})
    public ResponseEntity<ResponseDTO> handleEntityToDTOConvertException(UniqueEntityException e){
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ResponseDTO> handleNotFoundException(UniqueEntityException e){
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DataBaseException.class})
    public ResponseEntity<ResponseDTO> handleDataBaseException(UniqueEntityException e){
        return new ResponseEntity<>(initExceptionResponse(e), HttpStatus.BAD_REQUEST);
    }

    public ResponseDTO initExceptionResponse(RuntimeException e){
        ResponseDTO responseDTO = new ResponseDTO(e);
        return responseDTO;
    }
}
