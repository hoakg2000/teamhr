package com.tma.teamhr.DTO.ResponseDTO;

import com.tma.teamhr.model.Article;
import com.tma.teamhr.model.Team;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Getter
@Setter
public class ArticleResponseDTO {

    private String title;
    private Blob content;
    private Team team;

    public ArticleResponseDTO(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
        this.team = article.getTeam();
    }
}
