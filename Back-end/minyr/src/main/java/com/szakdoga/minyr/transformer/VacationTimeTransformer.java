package com.szakdoga.minyr.transformer;

import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.persistence.entity.VacationEntity;
import com.szakdoga.minyr.persistence.entity.VacationTimeEntity;
import org.springframework.stereotype.Service;

@Service
public class VacationTimeTransformer {

    public VacationTimeEntity transform(VacationTime vacationTime) {
        VacationTimeEntity entity = new VacationTimeEntity();
        entity.setId(vacationTime.getId());
        entity.setStart(vacationTime.getStart());
        entity.setEnd(vacationTime.getEnd());
        entity.setType(vacationTime.getType());
        return entity;
    }
}
