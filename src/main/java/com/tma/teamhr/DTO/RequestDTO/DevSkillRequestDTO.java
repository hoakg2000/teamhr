package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class DevSkillRequestDTO {

    @Range(min = 1)
    private int skill_id;
}
