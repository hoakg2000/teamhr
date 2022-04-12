package com.tma.teamhr.model;

import com.tma.teamhr.DTO.RequestDTO.ColumnRequestDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "columnn")
@Getter
@Setter
public class Columnn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

//    @Enumerated(EnumType.ORDINAL)
    private String type;

    public void DTOtoEntity(ColumnRequestDTO requestDTO){
        this.name = requestDTO.getName();
        this.type = ColumnType.values()[requestDTO.getType()].toString();
    }
}
