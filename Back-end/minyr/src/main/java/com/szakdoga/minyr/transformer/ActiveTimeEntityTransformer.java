package com.szakdoga.minyr.transformer;

import java.util.ArrayList;
import java.util.List;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.persistence.entity.ActiveTimeEntity;
import org.springframework.stereotype.Service;

@Service
public class ActiveTimeEntityTransformer {

    public ActiveTime transform(ActiveTimeEntity entity) {
        ActiveTime activeTime = new ActiveTime();
        activeTime.setArrival(entity.getArrival());
        activeTime.setDeparture(entity.getDeparture());
        activeTime.setId(entity.getId());
        return activeTime;
    }

    public List<ActiveTime> transform(List<ActiveTimeEntity> entities) {
        List<ActiveTime> activeTimes = new ArrayList<>();
        if (entities != null) {
            for (ActiveTimeEntity entity : entities) {
                activeTimes.add(transform(entity));
            }
        }
        return activeTimes;
    }
}
