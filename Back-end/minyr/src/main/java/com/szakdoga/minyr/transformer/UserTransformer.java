package com.szakdoga.minyr.transformer;

import com.szakdoga.minyr.model.User;
import com.szakdoga.minyr.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTransformer {

    @Autowired
    private VacationTransformer vacationTransformer;
    @Autowired
    private ActiveTimeTransformer activeTimeTransformer;

    public UserEntity transform(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setPasswd(user.getPasswd());
        userEntity.setVacation(vacationTransformer.transform(user.getVacation()));
        userEntity.setActiveTimes(activeTimeTransformer.transform(user.getActiveTimes()));
        userEntity.setIsAdmin(user.getIsAdmin());
        return userEntity;
    }
}
