package com.tma.teamhr.service;

import com.tma.teamhr.DTO.RequestDTO.TeamRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;

public interface ITeamService {
    TeamResponseDTO update(TeamRequestDTO requestDTO);
}
