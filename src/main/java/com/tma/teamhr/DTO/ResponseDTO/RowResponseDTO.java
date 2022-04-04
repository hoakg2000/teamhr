package com.tma.teamhr.DTO.ResponseDTO;

import com.tma.teamhr.model.Columnn;
import com.tma.teamhr.model.Dev;
import com.tma.teamhr.model.Row;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RowResponseDTO {
    private int id;
    private Columnn column;
    private Dev dev;
    private String value;

    public RowResponseDTO(Row row){
        this.id = row.getId();
        this.column = row.getColumn();
        this.dev = row.getDev();
        this.value = row.getValue();
    }
}
