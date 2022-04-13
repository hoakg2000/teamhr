package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.ExceptionHandler.ApiRequestException;
import com.tma.teamhr.service.DevService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Map;

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

    @PostMapping("/{id}/update")
    public ResponseEntity<ResponseDTO> getAll(@PathVariable int id,
                                              @Valid @RequestBody DevRequestDTO requestDTO){
        requestDTO.setId(id);

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(devService.update(requestDTO));
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

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody DevRequestDTO requestDTO){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(devService.create(requestDTO));
        responseDTO.setMessage(message.CREATE_SUCCESS);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);

        devService.delete(id);

        responseDTO.setMessage(message.DELETE);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/get/sorted")
    public ResponseEntity<ResponseDTO> getSorted(@RequestParam(required = false) Map<String, String> params){
        int page;
        try {
            page = Integer.parseInt(params.getOrDefault("page", "0"));
        }catch (Exception ex){
            throw new ApiRequestException("Page must be integer value");
        }
        ResponseDTO responseDTO = new ResponseDTO();
//        System.out.println(page);
        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(devService.getAllSortedByName(page));
        responseDTO.setMessage(message.GET);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
