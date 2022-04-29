package com.szakdoga.minyr.controller;

import com.szakdoga.minyr.model.Vacation;
import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.service.VacationService;
import com.szakdoga.minyr.service.VacationTimeService;
import com.szakdoga.minyr.view.CreateVacationTimeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vacationTime")
@CrossOrigin
public class VacationTimeController {

    private static final String CREATE = "/create";
    private static final String DELETE_BY_ID = "/delete-by-id/{id}";
    private static final String GET_BY_ID = "/get-by-id/{id}";
    @Autowired
    private VacationTimeService vacationTimeService;
    @Autowired
    private VacationService vacationService;



    @PutMapping(CREATE)
    public Vacation create(@RequestBody CreateVacationTimeRequest createVacationTimeRequest){
            Vacation vacation = vacationService.getById(createVacationTimeRequest.getVacationId());
            VacationTime vacationTime = new VacationTime();
            vacationTime.setStart(createVacationTimeRequest.getStartDate());
            vacationTime.setEnd(createVacationTimeRequest.getEndDate());
            vacationTime.setType(createVacationTimeRequest.getType());
            List<VacationTime> vacationTimeList = vacation.getVacationTimeList();
            vacationTimeList.add(vacationTime);
            vacation.setVacationTimeList(vacationTimeList);
        return vacationService.updateVacation(vacation);
    }

/*
    @GetMapping(DELETE_BY_ID)
    public void deleteById(@PathVariable long id){
        vacationTimeService.deleteById(id);
    }
    @GetMapping(GET_BY_ID)
    public VacationTime getById(@PathVariable long id){
        return vacationTimeService.getById(id);
    }

 */

}
