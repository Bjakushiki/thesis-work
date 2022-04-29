package com.szakdoga.minyr.transformer;

import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.persistence.entity.VacationTimeEntity;
import org.springframework.stereotype.Service;

@Service
public class VacationTimeEntityTransformer {

    public VacationTime transform(VacationTimeEntity entity) {
        VacationTime vacationTime = new VacationTime();
        vacationTime.setId(entity.getId());
        vacationTime.setStart(entity.getStart());
        vacationTime.setEnd(entity.getEnd());
        vacationTime.setType(entity.getType());
        return vacationTime;
    }
}
