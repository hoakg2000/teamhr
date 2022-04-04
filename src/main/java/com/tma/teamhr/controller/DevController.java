package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.service.IDevService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/api/v1/devs")
public class DevController {

    @Autowired
    private IDevService devService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody DevRequestDTO devRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            DevResponseDTO data = devService.create(devRequestDTO);
            responseDTO.setHeader(200);
            responseDTO.setData(data);
            responseDTO.setMessage(message.CREATE);
        } catch ( SQLIntegrityConstraintViolationException e) {
            responseDTO.setHeader(400);
            responseDTO.setError(e.getMessage());
        } catch (Exception ex){
            responseDTO.setHeader(400);
            responseDTO.setError(ex.getMessage());
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
