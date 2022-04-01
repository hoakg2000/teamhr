package com.tma.teamhr.pojos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "row",
        uniqueConstraints = {@UniqueConstraint(columnNames={"column_id", "dev_id"})})
@Getter
@Setter
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "column_id")
    private Columnn column;

    @ManyToOne
    @JoinColumn(name = "dev_id")
    private Dev dev;

    private String value;
}
