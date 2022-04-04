package com.tma.teamhr.service.impl;

import com.tma.teamhr.model.Dev;
import com.tma.teamhr.repository.IDevRepository;
import com.tma.teamhr.service.IDevService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Transactional
@Service
public class DevService implements IDevService {

    @Autowired
    private IDevRepository devRepository;

    @Override
    public Boolean delete(int id) {
        Optional<Dev> devOptional = devRepository.findById(id);
        if (devOptional.isEmpty())
            throw new NullPointerException(message.NOTEXIST_ID + id);
        try {
            devRepository.delete(devOptional.get());
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
