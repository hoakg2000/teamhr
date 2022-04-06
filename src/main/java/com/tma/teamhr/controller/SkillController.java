package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.SkillResponseDTO;
import com.tma.teamhr.service.SkillService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1/skills")
@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping("/get")
    public ResponseEntity<ResponseDTO> getAll(){
        ResponseDTO responseDTO = new ResponseDTO();
        List<SkillResponseDTO> skillList;
        try {
            skillList = skillService.getAll();
            responseDTO.setData(skillList);
        }catch (Exception ex){
            ex.printStackTrace();
            responseDTO.setError(ex.getMessage());
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        if (skillList.isEmpty())
            responseDTO.setMessage(message.GET_EMPTY);
        else
            responseDTO.setMessage(message.GET);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<ResponseDTO> update(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();

        try {
            Boolean status = skillService.delete(id);
            responseDTO.setHeader(200);
            responseDTO.setMessage(message.DELETE);
        }catch (NullPointerException ex){
            responseDTO.setHeader(400);
            responseDTO.setError(ex.getMessage() + id);
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<ResponseDTO> update(@PathVariable int id,
                                              @Valid @RequestBody SkillRequestDTO skillRequestDTO){
        skillRequestDTO.setId(id);
        ResponseDTO responseDTO = new ResponseDTO();

        SkillResponseDTO skill = skillService.update(skillRequestDTO);

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(skill);
        responseDTO.setMessage(message.UPDATE);



        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/get")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setHeader(200);
        try {
            SkillResponseDTO skill = skillService.getById(id);
            responseDTO.setData(skill);
            responseDTO.setMessage(message.GET);
        }catch (NullPointerException ex){
            responseDTO.setError(ex.getMessage() + id);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody SkillRequestDTO skillRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();

        SkillResponseDTO data = skillService.create(skillRequestDTO);

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(data);
        responseDTO.setMessage("Create success");

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
