package com.tma.teamhr.service;

import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.SkillResponseDTO;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface ISkillService {
    SkillResponseDTO getById(int id);
    List<SkillResponseDTO> getAll();
    SkillResponseDTO create(SkillRequestDTO skill) throws SQLIntegrityConstraintViolationException;
    SkillResponseDTO update(SkillRequestDTO skill) throws SQLIntegrityConstraintViolationException;
    Boolean delete(int id);
}
