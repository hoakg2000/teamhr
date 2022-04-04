package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.repository.IDevRepository;
import com.tma.teamhr.service.IDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class DevService implements IDevService {

    @Autowired
    private IDevRepository devRepository;

    @Override
    public List<DevResponseDTO> getAll() {
        Iterable<Dev> devIterable = devRepository.findAll();
        List<DevResponseDTO> devResponseDTOList = new ArrayList<>();
        devIterable.forEach(dev -> devResponseDTOList.add(new DevResponseDTO(dev)));
        return devResponseDTOList;
    }
}
