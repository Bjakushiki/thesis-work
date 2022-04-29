package com.szakdoga.minyr.transformer;

import com.szakdoga.minyr.model.Vacation;
import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.persistence.entity.VacationEntity;
import com.szakdoga.minyr.persistence.entity.VacationTimeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacationEntityTransformer {

    @Autowired
    private VacationTimeEntityTransformer vacationTimeEntityTransformer;

    public Vacation transform(VacationEntity entity) {
        Vacation vacation = new Vacation();
        vacation.setId(entity.getId());
        vacation.setAllVacation(entity.getAllVacation());
        List<VacationTime> vacations = new ArrayList<>();
        if(entity.getVacationTimeList() != null) {
            for (VacationTimeEntity vacationTimeEntitye : entity.getVacationTimeList()) {
                vacations.add(vacationTimeEntityTransformer.transform(vacationTimeEntitye));
            }
        }
        vacation.setVacationTimeList(vacations);
        vacation.setLastYearSurplus(entity.getLastYearSurplus());
        return vacation;
    }
}
