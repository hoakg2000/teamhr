package com.tma.teamhr.service.impl;

import com.tma.teamhr.repository.IColumnRepository;
import com.tma.teamhr.service.IColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ColumnService implements IColumnService {

    @Autowired
    private IColumnRepository columnRepository;

}
