package com.szakdoga.minyr.service;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.model.User;
import com.szakdoga.minyr.model.Vacation;
import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.persistence.dao.UserRepository;
import com.szakdoga.minyr.persistence.dao.VacationRepository;
import com.szakdoga.minyr.persistence.dao.VacationTimeRepository;
import com.szakdoga.minyr.transformer.*;
import com.szakdoga.minyr.view.UpdateVacationTimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class VacationTimeService {

    @Autowired
    private VacationTimeEntityTransformer vacationTimeEntityTransformer;
    @Autowired
    private VacationTimeTransformer vacationTimeTransformer;
    @Autowired
    private VacationTimeRepository vacationTimeRepository;
    @Autowired
    private VacationEntityTransformer vacationEntityTransformer;
    @Autowired
    private VacationTransformer vacationTransformer;
    @Autowired
    private VacationRepository vacationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTransformer userTransformer;
    @Autowired
    private UserEntityTransformer userEntityTransformer;

    public VacationTime create(VacationTime vacationTime){
        return vacationTimeEntityTransformer.transform(vacationTimeRepository.save(vacationTimeTransformer.transform(vacationTime)));
    }

    public VacationTime getById(long id){
        return vacationTimeEntityTransformer.transform(vacationTimeRepository.getById(id));
    }
    public void deleteById(long vid, long id){
        int i=0;
        Vacation vacation = vacationEntityTransformer.transform(vacationRepository.findById(vid));
        User user = userEntityTransformer.transform(userRepository.findByVacation(vacationTransformer.transform(vacation)));
        List<VacationTime> vacationTimes = vacation.getVacationTimeList();
        for (VacationTime vacationTime : vacationTimes){
            if (vacationTime.getId() == id) {
                vacationTimes.remove(i);
                break;
            }
            else {
                i++;
            }
        }
        vacation.setVacationTimeList(vacationTimes);
        user.setVacation(vacation);
        userRepository.save(userTransformer.transform(user));
    }

    public void updateById( long vid,  long id, UpdateVacationTimeRequest updateVacationTimeRequest){
        Vacation vacation = vacationEntityTransformer.transform(vacationRepository.findById(vid));
        User user = userEntityTransformer.transform(userRepository.findByVacation(vacationTransformer.transform(vacation)));
        List<VacationTime> vacationTimes = vacation.getVacationTimeList();
        for (VacationTime vacationTime : vacationTimes){
            if (vacationTime.getId() == id) {
                vacationTime.setStart(updateVacationTimeRequest.getStart());
                vacationTime.setEnd(updateVacationTimeRequest.getEnd());
                vacationTime.setType(updateVacationTimeRequest.getType());
                break;
            }
        }
        vacation.setVacationTimeList(vacationTimes);
        user.setVacation(vacation);
        userRepository.save(userTransformer.transform(user));
    }

}
