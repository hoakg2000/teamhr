package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.TeamRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.model.Team;
import com.tma.teamhr.repository.ITeamRepository;
import com.tma.teamhr.service.ITeamService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TeamService implements ITeamService {

    @Autowired
    private ITeamRepository teamRepository;

    @Override
    public TeamResponseDTO update(TeamRequestDTO requestDTO) {
        Optional<Team> optionalTeam = teamRepository.findById(requestDTO.getId());
        if (optionalTeam.isEmpty())
            throw new NullPointerException(message.NOTEXIST_ID + requestDTO.getId());

        Team team = optionalTeam.get();

        team.DTOtoEntity(requestDTO);

        teamRepository.save(team);
        return new TeamResponseDTO(team);
    }
}
