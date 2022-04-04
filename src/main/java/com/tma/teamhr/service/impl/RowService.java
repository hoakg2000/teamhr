package com.tma.teamhr.service.impl;

import com.tma.teamhr.repository.IRowRepository;
import com.tma.teamhr.service.IRowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RowService implements IRowService {

    @Autowired
    private IRowRepository rowRepository;

}
