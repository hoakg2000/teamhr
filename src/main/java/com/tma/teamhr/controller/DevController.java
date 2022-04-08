package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.service.DevService;
import com.tma.teamhr.utils.message;
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
    private DevService devService;

    @PostMapping("/get")
    public ResponseEntity<ResponseDTO> getAll(){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(devService.getAll());
        responseDTO.setMessage(message.GET);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/get")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(devService.getById(id));
        responseDTO.setMessage(message.GET);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
