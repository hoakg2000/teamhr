package com.tma.teamhr.DTO.RequestDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

public class TeamRequestDTO {

    @NotNull
    @Size(min = 3)
    private String name;

    private Collection<Integer> devs;
}
