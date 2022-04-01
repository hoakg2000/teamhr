package com.tma.teamhr.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tma.teamhr.DTO.RequestDTO.DevRequestDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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

    public Dev(DevRequestDTO devRequestDTO){
        this.name = devRequestDTO.getName();
        this.idNumber = devRequestDTO.getIdNumber();
        this.phoneNumber = devRequestDTO.getPhoneNumber();
        this.birth = devRequestDTO.getBirth();
    }
}
