package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.service.ITeamService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @PostMapping("/get")
    public ResponseEntity<ResponseDTO> getAll(){
        ResponseDTO responseDTO = new ResponseDTO();
        List<TeamResponseDTO> teamResponseDTOList = teamService.getAll();

        responseDTO.setHeader(200);
        responseDTO.setData(teamResponseDTOList);
        if (teamResponseDTOList.isEmpty()){
            responseDTO.setMessage(message.GET_EMPTY);
        }else {
            responseDTO.setMessage(message.GET);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
