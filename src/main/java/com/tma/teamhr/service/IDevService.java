package com.tma.teamhr.service;

import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;

public interface IDevService {
    DevResponseDTO getById(int id);
}
