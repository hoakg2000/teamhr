package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.service.IDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/devs")
public class DevController {

    @Autowired
    private IDevService devService;

    @PostMapping("/{id}/get")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            DevResponseDTO devResponseDTO = devService.getById(id);
            responseDTO.setHeader(200);
            responseDTO.setData(devResponseDTO);
        }catch (NullPointerException ex){
            responseDTO.setHeader(400);
            responseDTO.setError(ex.getMessage());
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
