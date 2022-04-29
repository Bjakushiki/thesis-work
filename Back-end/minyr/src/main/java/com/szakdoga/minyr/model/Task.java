package com.szakdoga.minyr.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class Task {
    private long id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;
    private User reporter;
    private User assignee;
    private Duration workingHours;

}
