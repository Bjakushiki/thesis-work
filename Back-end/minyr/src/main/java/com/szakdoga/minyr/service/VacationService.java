package com.szakdoga.minyr.service;

import com.szakdoga.minyr.model.Vacation;
import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.persistence.dao.VacationRepository;
import com.szakdoga.minyr.persistence.entity.VacationEntity;
import com.szakdoga.minyr.transformer.VacationEntityTransformer;
import com.szakdoga.minyr.transformer.VacationTransformer;
import com.szakdoga.minyr.view.CreateVacationTimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VacationService {
    @Autowired
    private VacationEntityTransformer vacationEntityTransformer;
    @Autowired
    private VacationTransformer vacationTransformer;
    @Autowired
    private VacationRepository vacationRepository;

    public Vacation create(Vacation vacation){
        return vacationEntityTransformer.transform(vacationRepository.save(vacationTransformer.transform(vacation)));
    }

    public Vacation getById(long id){
        return vacationEntityTransformer.transform(vacationRepository.getById(id));
    }

    public void deleteById(long id){
        vacationRepository.deleteById(id);
    }

    public Vacation updateVacation(Vacation vacation){
        Long takenDays = 0L;
        for( VacationTime vacationTime : vacation.getVacationTimeList() ){
            takenDays = Duration.between(vacationTime.getStart(),vacationTime.getEnd()).toDays();
        }
        if( takenDays <= (vacation.getAllVacation() + vacation.getLastYearSurplus()) ){
           vacation = vacationEntityTransformer.transform(vacationRepository.save(vacationTransformer.transform(vacation)));
        }
        return vacation;
    }
    public String updateMaxVacation(Vacation vacation){
        if (vacationEntityTransformer.transform(vacationRepository.save(vacationTransformer.transform(vacation))) != null){
            return "Sikeres mentés";
        }
        else{
            return "Mentési hiba";
        }
    }
}
