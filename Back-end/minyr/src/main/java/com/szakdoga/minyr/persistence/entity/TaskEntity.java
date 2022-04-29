package com.szakdoga.minyr.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

import com.szakdoga.minyr.model.Status;

@Entity
@Table
@Getter
@Setter
public class TaskEntity {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(cascade = CascadeType.DETACH )
    private UserEntity reporter;
    @ManyToOne(cascade = CascadeType.DETACH)
    private UserEntity assignee;
    private Duration workingHours;

}
