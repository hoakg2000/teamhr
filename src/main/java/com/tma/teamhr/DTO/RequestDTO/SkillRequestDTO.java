package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SkillRequestDTO {

    private int id;

    @Size(min = 2)
    @NotNull
    private String name;
}
