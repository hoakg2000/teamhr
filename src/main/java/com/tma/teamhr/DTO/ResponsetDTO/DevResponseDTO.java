package com.tma.teamhr.DTO.ResponsetDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.pojos.Dev;
import com.tma.teamhr.pojos.Row;
import com.tma.teamhr.pojos.Skill;
import com.tma.teamhr.pojos.Team;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class DevResponseDTO {

    private int id;
    private String name;
    private Date birth;
    private Collection<Team> teams;
    private Collection<Skill> skills;

    public DevResponseDTO(Dev dev){
        this.id = dev.getId();
        this.name = dev.getName();
        this.birth = dev.getBirth();
        this.teams = dev.getTeams();
        this.skills = dev.getSkills();
    }
}
