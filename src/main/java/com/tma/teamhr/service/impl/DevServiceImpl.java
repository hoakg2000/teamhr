package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;
import com.tma.teamhr.ExceptionHandler.ApiRequestException;
import com.tma.teamhr.ExceptionHandler.NotFoundException;
import com.tma.teamhr.ExceptionHandler.UniqueEntityException;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.model.Skill;
import com.tma.teamhr.repository.DevRepository;
import com.tma.teamhr.repository.SkillRepository;
import com.tma.teamhr.service.DevService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DevServiceImpl implements DevService {

    @Autowired
    private DevRepository devRepository;

    @Autowired
    private SkillRepository skillRepository;

    public List<DevResponseDTO> getAll(){
        Iterable<Dev> devIterable = devRepository.findAll();
        List<DevResponseDTO> devList = new ArrayList<>();
        devIterable.forEach(dev -> devList.add(new DevResponseDTO(dev)));
        return devList;
    }

    public DevResponseDTO create(DevRequestDTO requestDTO){
        try {
            Dev dev = new Dev();
            dev.DTOtoEntity(requestDTO);
            devRepository.save(dev);
            return new DevResponseDTO(dev);
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
    }

    public DevResponseDTO getById(int id){
        Optional<Dev> optionalDev = devRepository.findById(id);
        if (optionalDev.isEmpty())
            throw new ApiRequestException(message.GET);
        return new DevResponseDTO(optionalDev.get());
    }

    @Override
    public DevResponseDTO update(DevRequestDTO requestDTO) {
        try {
            Optional<Dev> optionalDev = devRepository.findById(requestDTO.getId());
            if (optionalDev.isEmpty())
                throw new ApiRequestException(message.NOTEXIST_ID + requestDTO.getId());

            Dev dev = optionalDev.get();
            dev.DTOtoEntity(requestDTO);
            devRepository.save(dev);

            return new DevResponseDTO(dev);
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        try {
            if (devRepository.findById(id).isEmpty())
                throw new ApiRequestException(message.NOTEXIST_ID + id);

            devRepository.deleteById(id);

        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
    }

    @Override
    public DevResponseDTO addSkill(int devId, int skillId) {
        Optional<Skill> skill = skillRepository.findById(skillId);
        Optional<Dev> dev = devRepository.findById(devId);

        if (skill.isEmpty() || dev.isEmpty())
            throw new NotFoundException("Skill id not found");

        if (dev.get().getSkills().contains(skill.get())){
            throw new UniqueEntityException("Duplicate key dev and skill");
        }

        try {
            dev.get().addSkill(skill.get());
            return new DevResponseDTO(devRepository.save(dev.get()));
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
    }

    @Override
    public DevResponseDTO removeSkill(int devId, int skillId) {
        Optional<Skill> skill = skillRepository.findById(skillId);
        Optional<Dev> dev = devRepository.findById(devId);

        if (skill.isEmpty() || dev.isEmpty())
            throw new NotFoundException("Skill id not found");

        try {
            dev.get().removeSkill(skill.get());
            return new DevResponseDTO(devRepository.save(dev.get()));
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
    }
}
