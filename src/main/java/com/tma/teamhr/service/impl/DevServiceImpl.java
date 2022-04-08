package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.DevResponseDTO;
import com.tma.teamhr.ExceptionHandler.ApiRequestException;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.repository.DevRepository;
import com.tma.teamhr.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class DevServiceImpl implements DevService {

    @Autowired
    private DevRepository devRepository;

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
}
