package com.szakdoga.minyr.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class VacationEntity {
    @Id
    @GeneratedValue
    private long id;
    private int allVacation;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<VacationTimeEntity> vacationTimeList;
    private int lastYearSurplus;

}
