package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.SkillResponseDTO;
import com.tma.teamhr.ExceptionHandler.*;
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
        List<SkillResponseDTO> skillList = new ArrayList<>();
        skillRepository.findAll().forEach(skill -> {
           skillList.add(new SkillResponseDTO(skill));
        });
        return skillList;
    }

    @Override
    public void delete(int id){
        if (skillRepository.findById(id).isEmpty())
            throw new ApiRequestException(message.NOTEXIST_ID + id);

        try { //if devSkillRepository exist, check if skillid in records and throw DataBaseException
            skillRepository.deleteById(id);
        }catch (DataBaseException ex){
            throw new DataBaseException("Cant delete object due to foreign key");
        }
    }

    @Override
    public SkillResponseDTO getById(int id){

        Optional<Skill> optionalSkill = skillRepository.findById(id);
        if (optionalSkill.isEmpty())
            throw new NotFoundException(message.NOTEXIST_ID + id);

        return new SkillResponseDTO(optionalSkill.get());
    }

    @Override
    public SkillResponseDTO create(SkillRequestDTO requestDTO){
        if (!skillRepository.findByName(requestDTO.getName()).isEmpty())
            throw new ApiRequestException(requestDTO.toString() + " Already exist!!!");

        Skill skill = new Skill(requestDTO);
        skillRepository.save(skill);

        return new SkillResponseDTO(skill);
    }

    @Override
    public SkillResponseDTO update(SkillRequestDTO requestDTO) {

        Optional<Skill> optionalSkill = skillRepository.findById(requestDTO.getId());
        if (optionalSkill.isEmpty())
            throw new NotFoundException(message.NOTEXIST_ID + requestDTO.getId());

        List<Skill> skillList = skillRepository.findByNameAndIdNot(requestDTO.getName(), requestDTO.getId());
        if (!skillList.isEmpty())
            throw new UniqueEntityException(requestDTO.toString() + " Already exist!!!");

        Skill skill = optionalSkill.get();
        skill.DTOtoEntity(requestDTO);
        skillRepository.save(skill);

        return new SkillResponseDTO(skill);
    }
}
