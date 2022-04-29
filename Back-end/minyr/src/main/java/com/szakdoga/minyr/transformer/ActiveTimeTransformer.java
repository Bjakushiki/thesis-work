package com.szakdoga.minyr.transformer;

import java.util.ArrayList;
import java.util.List;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.persistence.entity.ActiveTimeEntity;
import org.springframework.stereotype.Service;

@Service
public class ActiveTimeTransformer {

    public ActiveTimeEntity transform(ActiveTime activeTime) {
        ActiveTimeEntity entity = new ActiveTimeEntity();
        entity.setId(activeTime.getId());
        entity.setArrival(activeTime.getArrival());
        entity.setDeparture(activeTime.getDeparture());
        return entity;
    }

    public List<ActiveTimeEntity> transform(List<ActiveTime> activeTimes) {
        List<ActiveTimeEntity> entities = new ArrayList<>();
        if (activeTimes != null) {
            for (ActiveTime activeTime : activeTimes) {
                entities.add(transform(activeTime));
            }
        }
        return entities;
    }
}
