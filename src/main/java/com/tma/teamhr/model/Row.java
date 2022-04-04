package com.tma.teamhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.DTO.RequestDTO.RowRequestDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "row",
        uniqueConstraints = {@UniqueConstraint(columnNames={"column_id", "dev_id"})})
@Getter
@Setter
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "column_id")
    private Columnn column;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dev_id")
    private Dev dev;

    private String value;

    public void DTOtoEntity(RowRequestDTO requestDTO){
        this.value = requestDTO.getValue();
    }
}
