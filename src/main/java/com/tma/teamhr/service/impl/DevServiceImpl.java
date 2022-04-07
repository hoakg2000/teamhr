package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;
import com.tma.teamhr.ExceptionHandler.ApiRequestException;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.repository.DevRepository;
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

    public List<DevResponseDTO> getAll(){
        Iterable<Dev> devIterable;
        try {
            devIterable = devRepository.findAll();
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }

        List<DevResponseDTO> devList = new ArrayList<>();
        devIterable.forEach(dev -> devList.add(new DevResponseDTO(dev)));
        return devList;
    }

    @Override
    public DevResponseDTO update(DevRequestDTO requestDTO) {
        Optional<Dev> optionalDev = devRepository.findById(requestDTO.getId());
        if (optionalDev.isEmpty())
            throw new ApiRequestException(message.NOTEXIST_ID + requestDTO.getId());

        Dev dev = optionalDev.get();
        dev.DTOtoEntity(requestDTO);
        try {
            devRepository.save(dev);
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }

        return new DevResponseDTO(dev);
    }
}
