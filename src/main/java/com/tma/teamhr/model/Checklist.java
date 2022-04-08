package com.tma.teamhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.DTO.RequestDTO.ChecklistRequestDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;


    public void DTOtoEntity(ChecklistRequestDTO requestDTO){
        this.title = requestDTO.getTitle();
    }
}
