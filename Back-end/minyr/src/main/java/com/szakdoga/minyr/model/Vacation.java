package com.szakdoga.minyr.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class Vacation {
    private long id;
    private int allVacation;
    private List<VacationTime> vacationTimeList;
    private int lastYearSurplus;

}
