package com.tma.teamhr.service;

import com.tma.teamhr.DTO.RequestDTO.TeamRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;

import java.util.List;

public interface TeamService {
    List<TeamResponseDTO> getAll();
    TeamResponseDTO getById(int id);
    void delete(int id);
    TeamResponseDTO create(TeamRequestDTO requestDTO);
    TeamResponseDTO update(TeamRequestDTO requestDTO);
    TeamResponseDTO addDev(int teamId, int devId);
}
