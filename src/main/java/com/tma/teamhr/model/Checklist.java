package com.tma.teamhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.DTO.RequestDTO.ChecklistRequestDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.Column;

import java.util.Date;

@Entity
@Table(name = "checklist")
@Getter
@Setter
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "team_id")
    private Team team;

    public void DTOtoEntity(ChecklistRequestDTO requestDTO){
        this.title = requestDTO.getTitle();
    }
}
