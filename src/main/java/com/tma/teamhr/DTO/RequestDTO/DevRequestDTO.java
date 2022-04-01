package com.tma.teamhr.DTO.RequestDTO;

import com.tma.teamhr.DTO.ResponsetDTO.DevResponseDTO;
import com.tma.teamhr.pojos.Dev;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class DevRequestDTO {

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    @Size(min = 9, max = 12)
    private String idNumber;

    @Size(min = 10, max = 20)
    private String phoneNumber;

    private Date birth;

    private Collection<Integer> teams;

    private Collection<Integer> skills;

}
