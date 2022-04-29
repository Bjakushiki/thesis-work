package com.szakdoga.minyr.view;

import com.szakdoga.minyr.model.Status;
import com.szakdoga.minyr.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateTaskRequest {
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
