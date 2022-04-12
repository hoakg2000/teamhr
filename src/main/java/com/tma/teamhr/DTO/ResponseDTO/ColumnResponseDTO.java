package com.tma.teamhr.DTO.ResponseDTO;

import com.tma.teamhr.model.Columnn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColumnResponseDTO {

    private int id;
    private String name;
    private String type;

    public ColumnResponseDTO(Columnn columnn){
        this.id = columnn.getId();
        this.name = columnn.getName();
        this.type = columnn.getType().toString();
    }
}
