package com.szakdoga.minyr.view;

import com.szakdoga.minyr.model.WorkDayType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateVacationTimeRequest {
    private LocalDateTime start;
    private LocalDateTime end;
    @Enumerated(EnumType.STRING)
    private WorkDayType type;
    private long id;
}
