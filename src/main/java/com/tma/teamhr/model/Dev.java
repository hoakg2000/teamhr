package com.tma.teamhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.ExceptionHandler.ApiRequestException;
import com.tma.teamhr.utils.message;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;


@Entity
@Table(name = "dev")
@Getter
@Setter
public class Dev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    private Date birth;

    public void DTOtoEntity(DevRequestDTO requestDTO){
        this.name = requestDTO.getName();
        this.idNumber = requestDTO.getIdNumber();
        this.phoneNumber = requestDTO.getPhoneNumber();
        try {
            this.birth = new SimpleDateFormat("dd/MM/yyyy").parse(requestDTO.getBirth());
        }catch (ParseException ex){
            throw new ApiRequestException(message.WRONG_DATE_FORMAT);
        }
    }

}
