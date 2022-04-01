package com.tma.teamhr.DTO.RequestDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChecklistRequestDTO {

    @NotNull
    @Size(min = 3)
    private String title;

    private int team_id;
}
