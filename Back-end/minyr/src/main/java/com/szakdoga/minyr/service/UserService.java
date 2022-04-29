package com.szakdoga.minyr.service;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.model.User;
import com.szakdoga.minyr.persistence.dao.UserRepository;
import com.szakdoga.minyr.persistence.entity.UserEntity;
import com.szakdoga.minyr.transformer.UserEntityTransformer;
import com.szakdoga.minyr.transformer.UserTransformer;
import com.szakdoga.minyr.view.CreateUserRequest;
import com.szakdoga.minyr.view.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTransformer userTransformer;
    @Autowired
    private UserEntityTransformer userEntityTransformer;

    public User create(User user){
        return userEntityTransformer.transform(userRepository.save(userTransformer.transform(user)));
    }

    public User getById(long id){
        return userEntityTransformer.transform(userRepository.findById(id));
    }
    public List<User> getAll(){
        return userEntityTransformer.transform(userRepository.findAll());
    }

    public void deleteById(long id){
        userRepository.deleteById(id);
    }

    public void update(long id, UpdateUserRequest user){
        User user1= userEntityTransformer.transform(userRepository.getById(id));
        user1.setName(user.getName());
        user1.setPasswd(user.getPasswd());
        userRepository.save(userTransformer.transform(user1));

    }

    public long login(User user){
        UserEntity user1 = userRepository.findByNameAndPasswd(user.getName(),user.getPasswd());
        if (user1 != null){
            return userEntityTransformer.transform(user1).getId();
        }
        else{
            return 0;
        }
    }
    public long adminLogin(User user){
        UserEntity user1 = userRepository.findByNameAndPasswd(user.getName(),user.getPasswd());
        if (user1 != null){
            User logedInUser = userEntityTransformer.transform(user1);
            if (logedInUser.getIsAdmin() == Boolean.TRUE){
                return logedInUser.getId();
            }
            else{
                return 9999;
            }

        }
        else{
            return 0;
        }
    }

    public String arrival(long id){
        User user = getById(id);
        ActiveTime activeTime = new ActiveTime();
        activeTime.setArrival(LocalDateTime.now());
        List<ActiveTime> activeTimes = user.getActiveTimes();
        activeTimes.add(activeTime);
        user.setActiveTimes(activeTimes);
        if(userEntityTransformer.transform(userRepository.save(userTransformer.transform(user))) != null){
              return "Sikees érkezés: " + activeTime.getArrival();
        }else{
            return "Mentési hiba";
        }

    }

    public User departure(long id){
        User user = getById(id);
        List<ActiveTime> activeTimes = user.getActiveTimes();
        ActiveTime activeTime = activeTimes.get(activeTimes.size()-1);
        activeTime.setDeparture(LocalDateTime.now());
        activeTimes.remove(activeTimes.size()-1);
        activeTimes.add(activeTime);
        return userEntityTransformer.transform(userRepository.save(userTransformer.transform(user)));
    }
}
