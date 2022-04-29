package com.szakdoga.minyr.view;

import com.szakdoga.minyr.model.Status;
import com.szakdoga.minyr.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateTaskRequest {
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Duration workingHours;
    private long reporterId;
    private long assigneeId;
}
