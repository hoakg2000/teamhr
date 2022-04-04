package com.tma.teamhr.service;

import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;

import java.sql.SQLIntegrityConstraintViolationException;

public interface IDevService {
    DevResponseDTO update(DevRequestDTO requestDTO) throws Exception;
}
