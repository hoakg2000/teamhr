package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ChecklistRequestDTO {

    @NotNull
    @Range(min = 1)
    private int team_id;

    @NotNull
    @Size(min = 3)
    private String title;

}
