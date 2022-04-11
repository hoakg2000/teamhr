package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.RequestDTO.ChecklistRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.model.Checklist;
import com.tma.teamhr.service.ChecklistService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/checklists")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @PostMapping("/get")
    public ResponseEntity<ResponseDTO> getAll(){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(checklistService.getAll());
        responseDTO.setMessage(message.GET);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/get")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(checklistService.getById(id));
        responseDTO.setMessage(message.GET);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody ChecklistRequestDTO checklistRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(checklistService.create(checklistRequestDTO));
        responseDTO.setMessage(message.GET);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<ResponseDTO> create(@PathVariable int id,
                                              @Valid @RequestBody ChecklistRequestDTO checklistRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        checklistRequestDTO.setId(id);

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(checklistService.create(checklistRequestDTO));
        responseDTO.setMessage(message.GET);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
