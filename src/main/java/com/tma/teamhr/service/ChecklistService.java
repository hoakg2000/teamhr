package com.tma.teamhr.service;

import com.tma.teamhr.DTO.RequestDTO.ChecklistRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.ChecklistResponseDTO;

import java.util.List;

public interface ChecklistService {
    List<ChecklistResponseDTO> getAll();
    ChecklistResponseDTO getById(int id);
    ChecklistResponseDTO create(ChecklistRequestDTO requestDTO);
}
