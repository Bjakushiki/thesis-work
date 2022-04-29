package com.szakdoga.minyr.transformer;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.model.User;
import com.szakdoga.minyr.persistence.entity.ActiveTimeEntity;
import com.szakdoga.minyr.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEntityTransformer {

    @Autowired
    private ActiveTimeEntityTransformer activeTimeEntityTransformer;
    @Autowired
    private VacationEntityTransformer vacationTransformer;

    public User transform(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setPasswd(userEntity.getPasswd());
        user.setVacation(vacationTransformer.transform(userEntity.getVacation()));
        user.setActiveTimes(activeTimeEntityTransformer.transform(userEntity.getActiveTimes()));
        user.setIsAdmin(userEntity.getIsAdmin());
        return user;
    }
    public List<User> transform(List<UserEntity> entities) {
        List<User> users = new ArrayList<>();
        if (entities != null) {
            for (UserEntity entity : entities) {
                users.add(transform(entity));
            }
        }
        return users;
    }
}
