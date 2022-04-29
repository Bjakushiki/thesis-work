package com.szakdoga.minyr.controller;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.model.User;
import com.szakdoga.minyr.model.Vacation;
import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.service.TaskService;
import com.szakdoga.minyr.service.UserService;
import com.szakdoga.minyr.view.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UserController {

    private static final String ARRIVAL_ID = "/arrival/{id}";
    private static final String DEPARTURE_ID = "/departure/{id}";
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    /*
    @GetMapping(GET_BY_ID)
    public User getById(@PathVariable long id){
        return userService.getById(id);
   }

    @GetMapping(DELETE_BY_ID)
    public void delete(@PathVariable long id){
        userService.deleteById(id);
    }
     */
/*
    @GetMapping(CREATE)
    public User create(@RequestBody CreateUserRequest user){
        User user1 = new User();
        user1.setName(user.getName());
        user1.setPasswd(user.getPasswd());
        Vacation vacation = new Vacation();
        vacation.setAllVacation(30);
        vacation.setLastYearSurplus(0);
        List<VacationTime> vacationTimes = new ArrayList<>();
        vacation.setList(vacationTimes);
        user1.setVacation(vacation);
        return userService.create(user1);
    }
    */

/*
    @GetMapping(UPDATE)
    public User update(@PathVariable long id){
        User user = userService.getById(id);

        return userService.update(user);
    }
    */

    @PutMapping("/login")
    public long login(@RequestBody CreateUserRequest user){
        User user1 = new User();
        user1.setName(user.getName());
        user1.setPasswd(user.getPasswd());
        return userService.login(user1);
    }


    @GetMapping(ARRIVAL_ID)
    public String arrival(@PathVariable long id){
        return userService.arrival(id);
    }
    @GetMapping(DEPARTURE_ID)
    public String departure(@PathVariable long id){
        User user = userService.departure(id);
        if (user != null){
            taskService.updateWorkingHourByUserId(id);
            return "Sikeres távozás" + LocalDateTime.now();
        }else {
            return "Hiba a mentésben";
        }

    }





}
