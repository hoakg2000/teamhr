package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import com.tma.teamhr.DTO.ResponsetDTO.ResponseDTO;
import com.tma.teamhr.DTO.ResponsetDTO.SkillResponseDTO;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.model.Skill;
import com.tma.teamhr.service.ISkillService;
import com.tma.teamhr.service.impl.SkillService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/api/v1/skills")
public class SkillController {

    @Autowired
    private ISkillService skillService;

    @PostMapping("/get")
    public ResponseEntity<ResponseDTO> getAll(){
        ResponseDTO responseDTO = new ResponseDTO();

        List<Skill> skillList = skillService.getAll();
        if (skillList.isEmpty()){
            responseDTO.setMessage(message.GET_EMPTY);
        }
        else{
            List<SkillResponseDTO> responseDTOS = new ArrayList<>();
            skillList.forEach(skill -> responseDTOS.add(new SkillResponseDTO(skill)));
            responseDTO.setData(responseDTOS);
            responseDTO.setMessage(message.GET);
        }


        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody SkillRequestDTO skillRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        Skill skill = new Skill();
        skill.DTOtoEntity(skillRequestDTO);
        try {
            Skill data = skillService.create(skill);
            responseDTO.setHeader(200);
            responseDTO.setData(new SkillResponseDTO(data));
            responseDTO.setMessage("Create success");
        } catch (SQLIntegrityConstraintViolationException e) {
            responseDTO.setHeader(400);
            responseDTO.setError(e.getMessage());
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/get")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setHeader(200);
        try {
            Skill skill = skillService.getById(id);
            responseDTO.setData(new SkillResponseDTO(skill));
            responseDTO.setMessage(message.GET);
        }catch (NullPointerException ex){
            responseDTO.setError(ex.getMessage() + id);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<ResponseDTO> update(@PathVariable int id,
                                              @Valid @RequestBody SkillRequestDTO skillRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        Skill skill = null;
        try {
            skill = skillService.getById(id);
        }catch (NullPointerException ex){
            responseDTO.setError(ex.getMessage() + id);
            responseDTO.setHeader(400);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }

        skill.DTOtoEntity(skillRequestDTO);
        skillService.update(skill);
        responseDTO.setHeader(200);
        responseDTO.setData(new SkillResponseDTO(skill));
        responseDTO.setMessage(message.UPDATE);

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


}
