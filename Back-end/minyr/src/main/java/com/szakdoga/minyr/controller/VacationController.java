package com.szakdoga.minyr.controller;

import com.szakdoga.minyr.model.Vacation;
import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.model.WorkDayType;
import com.szakdoga.minyr.service.VacationService;
import com.szakdoga.minyr.view.CreateVacationTimeRequest;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vacation")
@CrossOrigin
public class VacationController {

    private static final String CREATE = "/create";
    private static final String DELETE_BY_ID = "/delete-by-id/{id}";
    private static final String GET_BY_ID = "/get-by-id/{id}";
    @Autowired
    private VacationService vacationService;

/*
    @GetMapping(CREATE)
    public Vacation create(){
        Vacation vacation = new Vacation();
        vacation.setAllVacation(30);
        vacation.setLastYearSurplus(0);
        List<VacationTime> vacationTimes = new ArrayList<>();
        vacation.setList(vacationTimes);
        return vacationService.create(vacation);
    }

 */

    /*
    @GetMapping(DELETE_BY_ID)
    public void deleteById(@PathVariable long id){
        vacationService.deleteById(id);
    }

     */

    @GetMapping(GET_BY_ID)
    public Vacation getById(@PathVariable long id){
        return vacationService.getById(id);
    }

}
