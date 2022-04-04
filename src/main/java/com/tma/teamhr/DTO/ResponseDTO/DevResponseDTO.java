package com.tma.teamhr.DTO.ResponseDTO;

import com.tma.teamhr.model.Dev;
import com.tma.teamhr.model.Skill;
import com.tma.teamhr.model.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class DevResponseDTO {
    private int id;
    private String name;
    private String idNumber;
    private String phoneNumber;
    private Date birth;
    private Collection<Team> teams;
    private Collection<Skill> skills;

    public DevResponseDTO(Dev dev){
        this.id = dev.getId();
        this.name = dev.getName();
        this.idNumber = dev.getIdNumber();
        this.phoneNumber = dev.getPhoneNumber();
        this.birth = dev.getBirth();
        this.teams = dev.getTeams();
        this.skills = dev.getSkills();
    }
}
