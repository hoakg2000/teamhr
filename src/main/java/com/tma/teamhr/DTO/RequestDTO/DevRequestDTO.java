package com.tma.teamhr.DTO.RequestDTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class DevRequestDTO {

    private int id;
    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Size(min = 9, max = 12)
    private String badgeId;

    @Size(min = 10, max = 20)
    private String phone;

    @Size(min = 8, max  = 10)
    private String birth;

}
