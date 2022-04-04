package com.tma.teamhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.DTO.RequestDTO.ColumnRequestDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "column")
@Getter
@Setter
public class Columnn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private ColumnType type;

    @OneToMany(mappedBy = "column")
    @JsonIgnore
    private Collection<Row> rows;

    public void DTOtoEntity(ColumnRequestDTO requestDTO){
        this.name = requestDTO.getName();
//        this.type = requestDTO.getType();
    }
}
