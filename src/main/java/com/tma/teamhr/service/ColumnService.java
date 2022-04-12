package com.tma.teamhr.service;

import com.tma.teamhr.DTO.ResponseDTO.ColumnResponseDTO;

import java.util.List;

public interface ColumnService {
    List<ColumnResponseDTO> getAll();
}
