package com.tma.teamhr.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.Column;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "article")
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private Blob content;

    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    @javax.persistence.Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Team team;
}
