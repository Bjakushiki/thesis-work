package com.szakdoga.minyr.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class VacationTime {
    private long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private WorkDayType type;
}
