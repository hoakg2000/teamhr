package com.tma.teamhr.service.impl;

import com.tma.teamhr.repository.ITeamRepository;
import com.tma.teamhr.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TeamService implements ITeamService {

    @Autowired
    private ITeamRepository teamRepository;

}
