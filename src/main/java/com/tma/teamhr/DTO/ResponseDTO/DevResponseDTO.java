package com.tma.teamhr.DTO.ResponseDTO;

import com.tma.teamhr.model.Dev;
import com.tma.teamhr.model.Skill;
import com.tma.teamhr.model.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class DevResponseDTO {
    private int id;
    private String name;
    private String badgeId;
    private String phone;
    private Date birth;

    public DevResponseDTO(Dev dev){
        this.id = dev.getId();
        this.name = dev.getName();
        this.badgeId = dev.getBadgeId();
        this.phone = dev.getPhone();
        this.birth = dev.getBirth();
    }
}
