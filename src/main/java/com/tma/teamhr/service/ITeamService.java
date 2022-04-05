package com.tma.teamhr.service;

import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;

import java.util.List;

public interface ITeamService {
    List<TeamResponseDTO> getAll();
}
