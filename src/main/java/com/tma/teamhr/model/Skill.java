package com.tma.teamhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "skill")
@Getter
@Setter
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Dev> devs;

    public Skill(){}

    public Skill(SkillRequestDTO requestDTO){
        this.name = requestDTO.getName();
    }

    public void DTOtoEntity(SkillRequestDTO dto){
        this.name = dto.getName();
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
