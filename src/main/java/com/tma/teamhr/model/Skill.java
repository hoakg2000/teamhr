package com.tma.teamhr.model;

import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "skill")
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public void DTOtoEntity(SkillRequestDTO dto){
        this.name = dto.getName();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
