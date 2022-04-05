package com.tma.teamhr.controller;

import com.tma.teamhr.DTO.RequestDTO.TeamRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.service.ITeamService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamController {

    @Autowired
    private ITeamService teamService;

    @PostMapping("/{id}/update")
    public ResponseEntity<ResponseDTO> update(@Valid @RequestBody TeamRequestDTO teamRequestDTO,
                                              @PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();
        teamRequestDTO.setId(id);
        try {
            TeamResponseDTO data = teamService.update(teamRequestDTO);
            responseDTO.setHeader(200);
            responseDTO.setData(data);
            responseDTO.setMessage(message.UPDATE);
        } catch (Exception e) {
            responseDTO.setHeader(400);
            responseDTO.setError(e.getMessage());
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
