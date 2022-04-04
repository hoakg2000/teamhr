package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.repository.IDevRepository;
import com.tma.teamhr.service.IDevService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class DevService implements IDevService {

    @Autowired
    private IDevRepository devRepository;

    @Override
    public DevResponseDTO getById(int id) {
        Optional<Dev> optionalDev = devRepository.findById(id);
        if (optionalDev.isEmpty())
            throw new NullPointerException(message.NOTEXIST_ID + id);
        return new DevResponseDTO(optionalDev.get());
    }
}
