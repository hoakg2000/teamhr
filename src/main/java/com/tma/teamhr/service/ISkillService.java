package com.tma.teamhr.service;

import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import com.tma.teamhr.DTO.ResponsetDTO.SkillResponseDTO;
import com.tma.teamhr.model.Skill;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface ISkillService {
    Skill getById(int id);
    List<Skill> getAll();
    Skill create(Skill skill) throws SQLIntegrityConstraintViolationException;
    Skill update(Skill skill);
    Boolean delete(int id);
}
