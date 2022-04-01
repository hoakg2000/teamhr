package com.tma.teamhr.DTO.RequestDTO;

import com.tma.teamhr.pojos.Team;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.Date;

public class ArticleRequsetDTO {

    @NotNull
    private String title;

    @NotNull
    private Blob content;

//    @NotNull
//    private int team_id;
}
