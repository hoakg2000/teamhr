package com.tma.teamhr.service;

import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;

public interface ITeamService {
    TeamResponseDTO getById(int id);
}
