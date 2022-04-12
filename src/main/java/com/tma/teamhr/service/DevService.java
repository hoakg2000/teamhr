package com.tma.teamhr.service;

import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;

import java.util.List;

public interface DevService {
    List<DevResponseDTO> getAll();
    DevResponseDTO update(DevRequestDTO requestDTO);
    DevResponseDTO create(DevRequestDTO requestDTO);
    DevResponseDTO getById(int id);
    void delete(int id);
}
