package com.szakdoga.minyr.view;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateActiveTimeRequest {
    private long id;
    private LocalDateTime arrival;
    private LocalDateTime departure;
}
