package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.service.IDevService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/devs")
public class DevController {

    @Autowired
    private IDevService devService;

    @PostMapping("/get")
    public ResponseEntity<ResponseDTO> getAll(){
        ResponseDTO responseDTO = new ResponseDTO();
        List<DevResponseDTO> devList = devService.getAll();

        responseDTO.setHeader(200);
        responseDTO.setData(devList);
        if (devList.isEmpty()){
            responseDTO.setMessage(message.GET_EMPTY);
        }else {
            responseDTO.setMessage(message.GET);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
