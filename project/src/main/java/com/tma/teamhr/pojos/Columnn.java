package com.tma.teamhr.pojos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "column")
@Getter
@Setter
public class Columnn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private ColumnType type;

    @OneToMany(mappedBy = "column")
    private Collection<Row> rows;


}
