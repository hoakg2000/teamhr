package com.tma.teamhr.DTO.RequestDTO;

import com.tma.teamhr.pojos.Dev;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
public class SkillRequestDTO {

    private int id;

    @Size(min = 2)
    @NotNull
    private String name;
}
