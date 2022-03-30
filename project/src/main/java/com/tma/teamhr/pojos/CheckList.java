package com.tma.teamhr.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.Column;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "checklist")
@Getter
@Setter
public class CheckList {
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
    @JoinColumn(name = "team_id")
    private Team team;


}
