package com.tma.teamhr.DTO.ResponseDTO;

import com.tma.teamhr.model.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TeamResponseDTO {

    private int id;
    private String name;
    private Date createdAt;
    private Date updatedAt;

    public TeamResponseDTO(Team team){
        this.id = team.getId();
        this.name = team.getName();
        this.createdAt = team.getCreatedAt();
        this.updatedAt = team.getUpdatedAt();
    }
}
