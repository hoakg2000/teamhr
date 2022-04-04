package com.tma.teamhr.DTO.ResponseDTO;

import com.tma.teamhr.model.Article;
import com.tma.teamhr.model.Checklist;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.model.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class TeamResponseDTO {

    private int id;
    private String name;
    private Date createdAt;
    private Date updatedAt;
    private Collection<Article> articles;
    private Checklist checkList;
    private Collection<Dev> devs;

    public TeamResponseDTO(Team team){
        this.id = team.getId();
        this.name = team.getName();
        this.createdAt = team.getCreatedAt();
        this.updatedAt = team.getUpdatedAt();
        this.articles = team.getArticles();
        this.checkList = team.getCheckList();
        this.devs = team.getDevs();
    }
}
