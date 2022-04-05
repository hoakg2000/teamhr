package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.model.Team;
import com.tma.teamhr.repository.ITeamRepository;
import com.tma.teamhr.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class TeamService implements ITeamService {

    @Autowired
    private ITeamRepository teamRepository;

    @Override
    public List<TeamResponseDTO> getAll() {
        Iterable<Team> teamIterable = teamRepository.findAll();
        List<TeamResponseDTO> devResponseDTOList = new ArrayList<>();
        teamIterable.forEach(team -> devResponseDTOList.add(new TeamResponseDTO(team)));
        return devResponseDTOList;
    }
}
