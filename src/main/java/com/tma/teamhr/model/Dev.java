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

    @Column(name = "badge_id")
    private String badgeId;

    private String phone;

    private Date birth;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "dev_skill",
            joinColumns = @JoinColumn(name = "dev_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Collection<Skill> skills;

    private static final SimpleDateFormat birthStrFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void DTOtoEntity(DevRequestDTO requestDTO){
        this.name = requestDTO.getName();
        this.badgeId = requestDTO.getBadgeId();
        this.phone = requestDTO.getPhone();
        try {
            this.birth = birthStrFormat.parse(requestDTO.getBirth());
        }catch (ParseException ex){
            throw new ApiRequestException(message.WRONG_DATE_FORMAT);
        }
    }

}
