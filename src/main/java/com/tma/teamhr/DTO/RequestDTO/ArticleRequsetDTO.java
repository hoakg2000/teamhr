package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Getter
@Setter
public class ArticleRequsetDTO {

    @NotNull
    private String title;

    @NotNull
    private Blob content;

    @NotNull
    private int teamId;
}
