package com.szakdoga.minyr.service;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.model.User;
import com.szakdoga.minyr.persistence.dao.ActiveTimeRepository;
import com.szakdoga.minyr.persistence.dao.UserRepository;
import com.szakdoga.minyr.persistence.entity.ActiveTimeEntity;
import com.szakdoga.minyr.transformer.ActiveTimeEntityTransformer;
import com.szakdoga.minyr.transformer.ActiveTimeTransformer;
import com.szakdoga.minyr.transformer.UserEntityTransformer;
import com.szakdoga.minyr.transformer.UserTransformer;
import com.szakdoga.minyr.view.CreateActiveTimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveTimeService {
    @Autowired
    private ActiveTimeRepository activeTimeRepository;
    @Autowired
    private ActiveTimeEntityTransformer activeTimeEntityTransformer;
    @Autowired
    private ActiveTimeTransformer activeTimeTransformer;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTransformer userTransformer;
    @Autowired
    private UserEntityTransformer userEntityTransformer;

    public ActiveTime create(ActiveTime activeTime){
        return activeTimeEntityTransformer.transform(activeTimeRepository.save(activeTimeTransformer.transform(activeTime)));
    }

    public ActiveTime getById(long id){
        ActiveTimeEntity activeTimeEntity = activeTimeRepository.getById(id);
        return activeTimeEntityTransformer.transform(activeTimeEntity);
    }

    public void deleteById(long uid, long id){
        int i=0;
        User user = userEntityTransformer.transform(userRepository.findById(uid));
        ActiveTime activeTime = activeTimeEntityTransformer.transform(activeTimeRepository.getById(id));
        List<ActiveTime> activeTimeList = user.getActiveTimes();
        for (ActiveTime activeTime1 : activeTimeList){
            if (activeTime1.getId() == activeTime.getId()) {
                activeTimeList.remove(i);
                break;
            }
            else {
                i++;
            }
        }
        user.setActiveTimes(activeTimeList);
        userRepository.save(userTransformer.transform(user));
    }

    public void update(long uid, long id, CreateActiveTimeRequest createActiveTimeRequestactiveTime){
        int i = 0;
        User user = userEntityTransformer.transform(userRepository.findById(uid));
        ActiveTime activeTime = activeTimeEntityTransformer.transform(activeTimeRepository.getById(id));
        List<ActiveTime> activeTimeList = user.getActiveTimes();
        for (ActiveTime activeTime1 : activeTimeList){
            if (activeTime1.getId() == activeTime.getId()) {
                activeTime1.setArrival(createActiveTimeRequestactiveTime.getArrival());
                activeTime1.setDeparture(createActiveTimeRequestactiveTime.getDeparture());
                break;
            }
            else {
                i++;
            }
        }
        user.setActiveTimes(activeTimeList);
        userRepository.save(userTransformer.transform(user));

       // return activeTimeEntityTransformer.transform(activeTimeRepository.save(activeTimeTransformer.transform(activeTime)));
    }
}
