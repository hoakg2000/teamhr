package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Getter
public class TeamDevRequestDTO {
    @Range(min = 1)
    @NotNull
    private Integer dev_id;
}
