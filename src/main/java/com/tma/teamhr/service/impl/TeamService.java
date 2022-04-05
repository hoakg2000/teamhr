package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.TeamRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.model.Team;
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

    @Override
    public TeamResponseDTO create(TeamRequestDTO requestDTO){
        Team dev = new Team();
        dev.DTOtoEntity(requestDTO);
        teamRepository.save(dev);
        return new TeamResponseDTO(dev);
    }
}
