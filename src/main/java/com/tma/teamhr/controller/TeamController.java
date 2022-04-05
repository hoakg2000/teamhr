package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.service.ITeamService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @PostMapping("/{id}/get")
    public ResponseEntity<ResponseDTO> getById(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            TeamResponseDTO teamResponseDTO = teamService.getById(id);
            responseDTO.setHeader(200);
            responseDTO.setData(teamResponseDTO);
            responseDTO.setMessage(message.GET);
        }catch (NullPointerException ex){
            responseDTO.setHeader(400);
            responseDTO.setError(ex.getMessage());
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
