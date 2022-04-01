package com.tma.teamhr.DTO.ResponsetDTO;

import com.tma.teamhr.pojos.Skill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillResponseDTO {
    private int id;
    private String name;

    public SkillResponseDTO(Skill skill){
        this.id = skill.getId();
        this.name = skill.getName();
    }
}
