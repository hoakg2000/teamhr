package com.tma.teamhr.service;

import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.SkillResponseDTO;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface SkillService {
    List<SkillResponseDTO> getAll();
    SkillResponseDTO create(SkillRequestDTO requestDTO) throws SQLIntegrityConstraintViolationException;
}
