package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.model.Team;
import com.tma.teamhr.repository.TeamRepository;
import com.tma.teamhr.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<TeamResponseDTO> getAll() {
        Iterable<Team> teamIterable = teamRepository.findAll();
        List<TeamResponseDTO> teamList = new ArrayList<>();
        teamIterable.forEach(team -> {
            teamList.add(new TeamResponseDTO(team));
        });
        return teamList;
    }
}
