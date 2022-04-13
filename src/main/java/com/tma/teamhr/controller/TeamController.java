package com.tma.teamhr.controller;


import com.tma.teamhr.DTO.RequestDTO.TeamDevRequestDTO;
import com.tma.teamhr.DTO.RequestDTO.TeamRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.ResponseDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.service.TeamService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        TeamResponseDTO teamResponseDTO = teamService.getById(id);

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(teamResponseDTO);
        responseDTO.setMessage(message.GET);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody TeamRequestDTO requestDTO){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(teamService.create(requestDTO));
        responseDTO.setMessage(message.GET);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<ResponseDTO> delete(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO();

        teamService.delete(id);
        responseDTO.setMessage(message.DELETE);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{teamId}/devs/add")
    public ResponseEntity<ResponseDTO> addDev(@PathVariable int teamId,
                                              @Valid @RequestBody TeamDevRequestDTO teamDevRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setData(teamService.addDev(teamId, teamDevRequestDTO.getDev_id()));
        responseDTO.setMessage(message.DELETE);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/{teamId}/devs/remove")
    public ResponseEntity<ResponseDTO> removeDev(@PathVariable int teamId,
                                              @Valid @RequestBody TeamDevRequestDTO teamDevRequestDTO){
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setHeader(HttpStatus.OK);
        responseDTO.setData(teamService.removeDev(teamId, teamDevRequestDTO.getDev_id()));
        responseDTO.setMessage(message.UPDATE);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
