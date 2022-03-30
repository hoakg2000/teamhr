package com.tma.teamhr.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RowId {
    @Column(name = "dev_id")
    private int devId;
    @Column(name = "column_id")
    private int columnId;
}
