package com.tma.teamhr.service;

import com.tma.teamhr.DTO.ResponseDTO.SkillResponseDTO;

import java.util.List;

public interface SkillService {
    List<SkillResponseDTO> getAll();
    SkillResponseDTO getById(int id);
}
