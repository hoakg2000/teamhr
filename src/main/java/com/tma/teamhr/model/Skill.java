package com.tma.teamhr.model;

//import com.tma.teamhr.DTO.RequestDTO.SkillRequestDTO;
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

    @ManyToMany(mappedBy = "skills")
    private Collection<Dev> devs;

//    public void DTOtoEntity(SkillRequestDTO dto){
//        this.name = dto.getName();
//    }
}
