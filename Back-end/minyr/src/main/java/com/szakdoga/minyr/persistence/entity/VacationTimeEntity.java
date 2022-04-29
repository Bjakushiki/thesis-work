package com.szakdoga.minyr.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import com.szakdoga.minyr.model.WorkDayType;

@Entity
@Table
@Getter
@Setter
public class VacationTimeEntity {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime start;
    private LocalDateTime end;
    @Enumerated(EnumType.STRING)
    private WorkDayType type;
}
