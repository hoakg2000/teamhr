package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.ColumnRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.ColumnResponseDTO;
import com.tma.teamhr.ExceptionHandler.ApiRequestException;
import com.tma.teamhr.model.Columnn;
import com.tma.teamhr.repository.ChecklistRepository;
import com.tma.teamhr.repository.ColumnRepository;
import com.tma.teamhr.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    private ColumnRepository columnRepository;

    @Autowired
    private ChecklistRepository checklistRepository;

    @Override
    public List<ColumnResponseDTO> getAll() {
        Iterable<Columnn> columnIterable = columnRepository.findAll();
        List<ColumnResponseDTO> columnResponseDTOList = new ArrayList<>();
        columnIterable.forEach(columnn -> {
            columnResponseDTOList.add(new ColumnResponseDTO(columnn));
        });
        return columnResponseDTOList;
    }

    @Override
    public ColumnResponseDTO create(ColumnRequestDTO requestDTO) {
        try {
            Columnn columnn = new Columnn();
            columnn.DTOtoEntity(requestDTO);
            columnn.setChecklist(checklistRepository.findById(requestDTO.getChecklistId()).get());
            columnRepository.save(columnn);
            return new ColumnResponseDTO(columnn);
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
    }
}
