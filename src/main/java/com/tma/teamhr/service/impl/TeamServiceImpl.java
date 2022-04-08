package com.tma.teamhr.service.impl;

import com.tma.teamhr.DTO.RequestDTO.TeamRequestDTO;
import com.tma.teamhr.DTO.ResponseDTO.TeamResponseDTO;
import com.tma.teamhr.ExceptionHandler.ApiRequestException;
import com.tma.teamhr.model.Team;
import com.tma.teamhr.repository.TeamRepository;
import com.tma.teamhr.service.TeamService;
import com.tma.teamhr.utils.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public TeamResponseDTO getById(int id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isEmpty())
            throw new ApiRequestException(message.NOTEXIST_ID);
        return new TeamResponseDTO(optionalTeam.get());
    }

    @Override
    public TeamResponseDTO update(TeamRequestDTO requestDTO) {
        Optional<Team> optionalTeam = teamRepository.findById(requestDTO.getId());
        if(optionalTeam.isEmpty())
            throw new ApiRequestException(message.NOTEXIST_ID);
        Team team = optionalTeam.get();
        team.DTOtoEntity(requestDTO);
        teamRepository.save(team);
        return new TeamResponseDTO(team);
    }

    @Override
    public TeamResponseDTO create(TeamRequestDTO requestDTO) {
        Team team = new Team();
        team.DTOtoEntity(requestDTO);
        try {
            teamRepository.save(team);
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
        return new TeamResponseDTO(team);
    }

    @Override
    public Boolean delete(int id) {
        if (teamRepository.findById(id).isEmpty())
            throw new ApiRequestException(message.NOTEXIST_ID + id);

        try {
            teamRepository.deleteById(id);
        }catch (Exception ex){
            throw new ApiRequestException(ex.getMessage());
        }
        return true;
    }
}
