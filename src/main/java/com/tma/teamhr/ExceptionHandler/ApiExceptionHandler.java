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
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(e.getMessage());
        responseDTO.setError(e);
        responseDTO.setHeader(status);
        responseDTO.setTime(ZonedDateTime.now(ZoneId.of("Z")));

        return new ResponseEntity<>(responseDTO, status);
    }
}
