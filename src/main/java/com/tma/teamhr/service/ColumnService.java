package com.tma.teamhr.service;

import com.tma.teamhr.DTO.RequestDTO.ColumnRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.ColumnResponseDTO;

import java.util.List;

public interface ColumnService {
    List<ColumnResponseDTO> getAll();
    ColumnResponseDTO create(ColumnRequestDTO requestDTO);
}
