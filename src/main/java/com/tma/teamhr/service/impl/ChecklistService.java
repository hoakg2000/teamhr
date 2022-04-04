package com.tma.teamhr.service.impl;

import com.tma.teamhr.repository.IChecklistRepository;
import com.tma.teamhr.service.IChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ChecklistService implements IChecklistService {

    @Autowired
    private IChecklistRepository checklistRepository;

}
