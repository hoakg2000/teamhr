package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.ResponseDTO.ChecklistResponseDTO;
import com.tma.teamhr.model.Checklist;
import com.tma.teamhr.repository.ChecklistRepository;
import com.tma.teamhr.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ChecklistServiceImpl implements ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    @Override
    public List<ChecklistResponseDTO> getAll() {
        Iterable<Checklist> checklistIterable = checklistRepository.findAll();
        List<ChecklistResponseDTO> checkList = new ArrayList<>();
        checklistIterable.forEach(check -> {
            checkList.add(new ChecklistResponseDTO(check));
        });
        return checkList;
    }


}
