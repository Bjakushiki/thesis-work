package com.szakdoga.minyr.transformer;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.model.Vacation;
import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.persistence.entity.ActiveTimeEntity;
import com.szakdoga.minyr.persistence.entity.VacationEntity;
import com.szakdoga.minyr.persistence.entity.VacationTimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacationTransformer {

    @Autowired
    private VacationTimeTransformer vacationTimeTransformer;

    public VacationEntity transform(Vacation vacation) {
        VacationEntity entity = new VacationEntity();
        entity.setId(vacation.getId());
        entity.setAllVacation(vacation.getAllVacation());

        List<VacationTimeEntity> entities = new ArrayList<>();
        if (vacation.getVacationTimeList() != null) {
            for (VacationTime vacationTime : vacation.getVacationTimeList()) {
                entities.add(vacationTimeTransformer.transform(vacationTime));
            }
        }
        entity.setVacationTimeList(entities);
        entity.setLastYearSurplus(vacation.getLastYearSurplus());
        return entity;
    }
}
