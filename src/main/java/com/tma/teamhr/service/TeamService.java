package com.tma.teamhr.service;

import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;

import java.util.List;

public interface TeamService {
    List<TeamResponseDTO> getAll();
    TeamResponseDTO getById(int id);
    Boolean delete(int id);
}
