package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@Setter
public class ColumnRequestDTO {

    @NotNull
    private String name;

    @NotNull
    @Range(min = 1)
    private int type;


}
