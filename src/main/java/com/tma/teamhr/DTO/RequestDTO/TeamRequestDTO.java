package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TeamRequestDTO {

    private int id;
    @NotNull
    @Size(min = 3)
    private String name;
}
