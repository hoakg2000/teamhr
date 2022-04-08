package com.tma.teamhr.controller;


import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.service.TeamService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/teams")
@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/get")
    public ResponseEntity<ResponseDTO> getAll(){
        ResponseDTO responseDTO = new ResponseDTO();
        List<TeamResponseDTO> skillList;
        skillList = teamService.getAll();
        responseDTO.setData(skillList);
        responseDTO.setMessage(message.GET);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/get")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();
//        responseDTO.setHeader(200);
//        try {
//            TeamResponseDTO teamResponseDTO = teamService.getById(id);
//            responseDTO.setData(teamResponseDTO);
//            responseDTO.setMessage(message.GET);
//        }catch (NullPointerException ex){
//            responseDTO.setError(ex.getMessage() + id);
//        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
