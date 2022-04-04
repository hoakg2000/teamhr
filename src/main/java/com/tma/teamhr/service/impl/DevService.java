package com.tma.teamhr.service.impl;

import com.tma.teamhr.repository.IDevRepository;
import com.tma.teamhr.service.IDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DevService implements IDevService {

    @Autowired
    private IDevRepository devRepository;

}
