package com.szakdoga.minyr.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActiveTime {
    private long id;
    private LocalDateTime arrival;
    private LocalDateTime departure;
}
