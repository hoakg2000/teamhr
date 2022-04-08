package com.tma.teamhr.service.impl;

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
        try {
            Iterable<Dev> devIterable = devRepository.findAll();
            List<DevResponseDTO> devList = new ArrayList<>();
            devIterable.forEach(dev -> devList.add(new DevResponseDTO(dev)));
            return devList;
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
}
