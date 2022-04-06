package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.SkillResponseDTO;
import com.tma.teamhr.ExceptionHandler.ApiRequestException;
import com.tma.teamhr.model.Skill;
import com.tma.teamhr.repository.SkillRepository;
import com.tma.teamhr.service.SkillService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Boolean delete(int id){

        Optional<Skill> optionalSkill = skillRepository.findById(id);
        if (optionalSkill.isEmpty())
            throw new NullPointerException(message.NOTEXIST_ID);
        try {
            skillRepository.deleteById(id);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public SkillResponseDTO getById(int id){

        Optional<Skill> optionalSkill = skillRepository.findById(id);
        if (optionalSkill.isEmpty())
            throw new ApiRequestException(message.NOTEXIST_ID + id);

        return new SkillResponseDTO(optionalSkill.get());
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

    @Override
    public SkillResponseDTO update(SkillRequestDTO requestDTO) throws SQLIntegrityConstraintViolationException {

        Optional<Skill> optionalSkill = skillRepository.findById(requestDTO.getId());
        if (optionalSkill.isEmpty())
            throw new NullPointerException(message.NOTEXIST_ID);
        Skill skill = optionalSkill.get();

        List<Skill> skillList = skillRepository.getByName(requestDTO.getName());
        if (!skillList.isEmpty())
            throw new SQLIntegrityConstraintViolationException(requestDTO.toString() + " Already exist!!!");

        skill.DTOtoEntity(requestDTO);

        skillRepository.save(skill);
        return new SkillResponseDTO(skill);
    }
}
