package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.model.Team;
import com.tma.teamhr.repository.ITeamRepository;
import com.tma.teamhr.service.ITeamService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class TeamService implements ITeamService {

    @Autowired
    private ITeamRepository teamRepository;

    @Override
    public TeamResponseDTO getById(int id) {
        Optional<Team> optionalDev = teamRepository.findById(id);
        if (optionalDev.isEmpty())
            throw new NullPointerException(message.NOTEXIST_ID + id);
        return new TeamResponseDTO(optionalDev.get());
    }
}
