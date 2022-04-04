package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RowRequestDTO {

    @NotNull
    private int columnId;

    @NotNull
    private int devId;

    @NotNull
    private String value;
}
