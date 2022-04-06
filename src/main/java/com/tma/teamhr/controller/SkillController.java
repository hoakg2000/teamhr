package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.SkillResponseDTO;
import com.tma.teamhr.service.SkillService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
