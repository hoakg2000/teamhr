package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.repository.IDevRepository;
import com.tma.teamhr.service.IDevService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DevService implements IDevService {

    @Autowired
    private IDevRepository devRepository;

    @Override
    public DevResponseDTO update(DevRequestDTO requestDTO) throws Exception {
        Optional<Dev> optionalDev = devRepository.findById(requestDTO.getId());
        if (optionalDev.isEmpty())
            throw new NullPointerException(message.NOTEXIST_ID + requestDTO.getId());

        Dev dev = optionalDev.get();

        dev.DTOtoEntity(requestDTO);
        List<Dev> devList = devRepository.findByIdNumber(dev.getIdNumber());
        if (!devList.isEmpty()) {
            for (Dev dev1 : devList) {
                if (dev1.getId() != dev.getId())
                    throw new SQLIntegrityConstraintViolationException("Duplicate id number");
            }
        }

        devRepository.save(dev);
        return new DevResponseDTO(dev);
    }
}
