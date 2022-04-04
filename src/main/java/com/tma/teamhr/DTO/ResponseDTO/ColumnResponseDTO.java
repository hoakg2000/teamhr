package com.tma.teamhr.DTO.ResponseDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.model.ColumnType;
import com.tma.teamhr.model.Columnn;
import com.tma.teamhr.model.Row;
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
    private Collection<Row> rows;

    public ColumnResponseDTO(Columnn columnn){
        this.id = columnn.getId();
        this.name = columnn.getName();
        this.type = columnn.getType().toString();
        this.rows = columnn.getRows();
    }
}
