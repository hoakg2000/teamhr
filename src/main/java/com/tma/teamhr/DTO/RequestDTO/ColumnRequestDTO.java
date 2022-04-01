package com.tma.teamhr.DTO.RequestDTO;

import com.tma.teamhr.pojos.ColumnType;
import com.tma.teamhr.pojos.Row;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public class ColumnRequestDTO {

    @NotNull
    private String name;

    @NotNull
    private ColumnType type;

    private Collection<Integer> row_ids;

}
