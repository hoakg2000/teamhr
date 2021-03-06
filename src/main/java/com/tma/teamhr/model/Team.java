package com.tma.teamhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.DTO.RequestDTO.TeamRequestDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.Date;

@Entity
@Table(name = "team")
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatedAt;

    @OneToOne(mappedBy = "team", fetch = FetchType.EAGER)
    @JsonIgnore
    private Checklist checkList;

    public void DTOtoEntity(TeamRequestDTO requestDTO){
        this.name = requestDTO.getName();
    }
}
