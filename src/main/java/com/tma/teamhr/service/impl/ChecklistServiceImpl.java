package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.ChecklistRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.ChecklistResponseDTO;
import com.tma.teamhr.ExceptionHandler.ApiRequestException;
import com.tma.teamhr.model.Checklist;
import com.tma.teamhr.repository.ChecklistRepository;
import com.tma.teamhr.repository.TeamRepository;
import com.tma.teamhr.service.ChecklistService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChecklistServiceImpl implements ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<ChecklistResponseDTO> getAll() {
        Iterable<Checklist> checklistIterable = checklistRepository.findAll();
        List<ChecklistResponseDTO> checkList = new ArrayList<>();
        checklistIterable.forEach(check -> {
            checkList.add(new ChecklistResponseDTO(check));
        });
        return checkList;
    }

    @Override
    public ChecklistResponseDTO getById(int id) {
        Optional<Checklist> optionalChecklist = checklistRepository.findById(id);
        if (optionalChecklist.isEmpty())
            throw new ApiRequestException(message.NOTEXIST_ID + id);

        return new ChecklistResponseDTO(optionalChecklist.get());
    }

    @Override
    public ChecklistResponseDTO create(ChecklistRequestDTO requestDTO) {
        try{
            Checklist checklist = new Checklist();
            checklist.DTOtoEntity(requestDTO);

            checklist.setTeam(teamRepository.findById(requestDTO.getTeam_id()).get());

            checklistRepository.save(checklist);
            return new ChecklistResponseDTO(checklist);
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
    }


}
