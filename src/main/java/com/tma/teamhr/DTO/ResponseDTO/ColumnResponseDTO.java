package com.tma.teamhr.DTO.ResponseDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.model.ColumnType;
import com.tma.teamhr.model.Column;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.Collection;

@Getter
@Setter
public class ColumnResponseDTO {

    private int id;
    private String name;
    private String type;

    public ColumnResponseDTO(Column column){
        this.id = column.getId();
        this.name = column.getName();
//        this.type = column.getType().toString();
    }
}
