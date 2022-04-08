package com.tma.teamhr.DTO.ResponseDTO;

import com.tma.teamhr.model.Checklist;
import com.tma.teamhr.model.Team;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ChecklistResponseDTO {
    private int id;
    private String title;
    private Date createdAt;
    private Date updatedAt;

    public ChecklistResponseDTO(Checklist checkList){
        this.id = checkList.getId();
        this.title = checkList.getTitle();
        this.createdAt = checkList.getCreatedAt();
        this.updatedAt = checkList.getUpdatedAt();
    }
}
