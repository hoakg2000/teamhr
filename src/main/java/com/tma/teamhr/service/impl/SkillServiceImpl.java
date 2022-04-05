package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.SkillResponseDTO;
import com.tma.teamhr.model.Skill;
import com.tma.teamhr.repository.SkillRepository;
import com.tma.teamhr.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<SkillResponseDTO> getAll() {
        Iterable<Skill> skillIterable = skillRepository.findAll();
        List<SkillResponseDTO> skillList = new ArrayList<>();
        skillIterable.forEach(skill -> {
            skillList.add(new SkillResponseDTO(skill));
        });
        return skillList;
    }

    @Override
    public SkillResponseDTO create(SkillRequestDTO requestDTO) throws SQLIntegrityConstraintViolationException {
        List<Skill> skillList = skillRepository.getByName(requestDTO.getName());
        if (!skillList.isEmpty())
            throw new SQLIntegrityConstraintViolationException(requestDTO.toString() + " Already exist!!!");

        Skill skill = new Skill();
        skill.DTOtoEntity(requestDTO);
        skillRepository.save(skill);

        return new SkillResponseDTO(skill);
    }
}