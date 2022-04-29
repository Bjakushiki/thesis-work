package com.szakdoga.minyr.controller;

import com.szakdoga.minyr.model.*;
import com.szakdoga.minyr.service.*;
import com.szakdoga.minyr.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:8081/")
public class AdminController {

    private static final String USER_GET_BY_ID = "/user/get-by-id/{id}";
    private static final String USER_DELETE_BY_ID = "/user/delete-by-id/{id}";
    private static final String USER_CREATE = "/user/create";
    private static final String USER_UPDATE = "user/update/{id}";
    private static final String TASK_DELETE_BY_ID = "/task/delete-by-id/{id}";
    private static final String TASK_GET_BY_ID = "/task/get-by-id/{id}";
    private static final String TASK_UPDATE_BY_ID = "/task/update/{id}";
    private static final String VACATION_DELETE_BY_ID = "/vacation/delete-by-id/{id}";
    private static final String VACATION_SET_MAXVACATION_ID_COUNT = "/vacation/setMaxvacation/{id}/{count}";
    private static final String ACTIVE_TIME_GET_BY_ID = "activeTime/get-by-id/{id}";
    private static final String ACTIVE_TIME_DELETE_BY_ID = "activeTime/delete-by-id/{uid}/{id}";
    private static final String VACATION_TIME_DELETE_BY_ID = "vacationTime/delete-by-id/{vid}/{id}";
    private static final String VACATION_TIME_GET_BY_ID = "vacationTime/get-by-id/{id}";
    @Autowired
    private VacationService vacationService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ActiveTimeService activeTimeService;
    @Autowired
    private VacationTimeService vacationTimeService;

    @PutMapping(USER_CREATE)
    public User userCreate(@RequestBody CreateUserRequest user){
        User user1 = new User();
        user1.setName(user.getName());
        user1.setPasswd(user.getPasswd());
        Vacation vacation = new Vacation();
        vacation.setAllVacation(30);
        vacation.setLastYearSurplus(0);
        List<VacationTime> vacationTimes = new ArrayList<>();
        vacation.setVacationTimeList(vacationTimes);
        user1.setVacation(vacation);
        return userService.create(user1);
    }

    @PutMapping(USER_UPDATE)
    public void userUpdate(@PathVariable long id,@RequestBody UpdateUserRequest user){
        userService.update(id,user);
    }

    @GetMapping("/user")
    public List<User> userGetAll(){
        return userService.getAll();
    }

    @GetMapping(USER_GET_BY_ID)
    public User userGetById(@PathVariable long id){
        return userService.getById(id);
    }


    @GetMapping(USER_DELETE_BY_ID)
    public void userDelete(@PathVariable long id){
        userService.deleteById(id);
    }


    @GetMapping(TASK_DELETE_BY_ID)
    public void taskDeleteById(@PathVariable long id){
        taskService.deleteById(id);
    }

    @GetMapping(TASK_GET_BY_ID)
    public Task taksGetById(@PathVariable long id){
        return taskService.getById(id);
    }

    @GetMapping(VACATION_DELETE_BY_ID)
    public void deleteById(@PathVariable long id){
        vacationService.deleteById(id);
    }

    @GetMapping(VACATION_SET_MAXVACATION_ID_COUNT)
    public String vacationMaxUpdateById(@PathVariable long id,@PathVariable int count){
        Vacation vacation = vacationService.getById(id);
        vacation.setAllVacation(count);
        return vacationService.updateMaxVacation(vacation);
    }
    @GetMapping(ACTIVE_TIME_GET_BY_ID)
    public ActiveTime activeTimeGetById(@PathVariable long id){
        return activeTimeService.getById(id);
    }

    @GetMapping(ACTIVE_TIME_DELETE_BY_ID)
    public void activeTimeDeleteById(@PathVariable long uid,@PathVariable long id){
        activeTimeService.deleteById(uid,id);
    }
    @PutMapping("/activeTime/update-by-id/{uid}/{id}")
    public void activeTimeUpdateById(@PathVariable long uid,@PathVariable long id, @RequestBody CreateActiveTimeRequest activeTimeRequest){
        activeTimeService.update(uid,id,activeTimeRequest);
    }
    @GetMapping(VACATION_TIME_DELETE_BY_ID)
    public void vacationTimeDeleteById(@PathVariable long vid, @PathVariable long id){
        vacationTimeService.deleteById(vid,id);
    }
    @GetMapping(VACATION_TIME_GET_BY_ID)
    public VacationTime getById(@PathVariable long id){
        return vacationTimeService.getById(id);
    }

    @PutMapping("/vacationTime/update-by-id/{vid}/{id}")
    public void vacationTimeUpdateById(@PathVariable long vid, @PathVariable long id, @RequestBody UpdateVacationTimeRequest updateVacationTimeRequest){
        vacationTimeService.updateById(vid,id,updateVacationTimeRequest);
    }
    @PutMapping("/user/login")
    public long login(@RequestBody CreateUserRequest user){
        User user1 = new User();
        user1.setName(user.getName());
        user1.setPasswd(user.getPasswd());
        return userService.adminLogin(user1);
    }
    @PutMapping(TASK_UPDATE_BY_ID)
    public void TaskUpdateById(@PathVariable long id, @RequestBody UpdateTaskRequest updateTaskRequest){
        taskService.updateById(id, updateTaskRequest);
    }
}
