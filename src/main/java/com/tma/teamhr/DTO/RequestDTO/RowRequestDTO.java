package com.tma.teamhr.DTO.RequestDTO;

import com.tma.teamhr.pojos.Columnn;
import com.tma.teamhr.pojos.Dev;

import javax.validation.constraints.NotNull;

public class RowRequestDTO {

    @NotNull
    private Columnn column;

    @NotNull
    private Dev dev;

    @NotNull
    private String value;
}
