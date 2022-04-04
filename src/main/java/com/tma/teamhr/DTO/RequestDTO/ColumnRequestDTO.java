package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@Setter
public class ColumnRequestDTO {

    @NotNull
    private String name;

    @NotNull
    private int type;

    private Collection<Integer> row_ids;

}
