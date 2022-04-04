package com.tma.teamhr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import com.tma.teamhr.utils.message;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
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

    @ManyToMany(mappedBy = "devs", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Team> teams;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "dev_skill",
            joinColumns = @JoinColumn(name = "dev_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Collection<Skill> skills;

    @OneToMany(mappedBy = "dev", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Row> rows;

    public void DTOtoEntity(DevRequestDTO requestDTO) throws Exception {
        this.name = requestDTO.getName();
        this.idNumber = requestDTO.getIdNumber();
        this.phoneNumber = requestDTO.getPhoneNumber();

        try {
            this.birth = new SimpleDateFormat("dd/MM/yyyy").parse(requestDTO.getBirth());;
        }catch (DateTimeParseException | ParseException ex){
            throw new Exception(message.DATE_PARSE_ERROR);
        }
    }

}
