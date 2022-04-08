package com.tma.teamhr.service;

import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;

import java.util.List;

public interface DevService {
    List<DevResponseDTO> getAll();
    void delete(int id);
}
