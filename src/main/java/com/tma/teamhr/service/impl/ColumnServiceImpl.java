package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.ResponseDTO.ColumnResponseDTO;
import com.tma.teamhr.model.Column;
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

    @Override
    public List<ColumnResponseDTO> getAll() {
        Iterable<Column> columnIterable = columnRepository.findAll();
        List<ColumnResponseDTO> columnResponseDTOList = new ArrayList<>();
        columnIterable.forEach(column -> {
            columnResponseDTOList.add(new ColumnResponseDTO(column));
        });
        return columnResponseDTOList;
    }
}
