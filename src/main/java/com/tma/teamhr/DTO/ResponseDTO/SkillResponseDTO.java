package com.tma.teamhr.DTO.ResponseDTO;

import com.tma.teamhr.model.Skill;
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

    @Override
    public String toString() {
        return this.name;
    }
}
