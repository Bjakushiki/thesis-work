package com.szakdoga.minyr.controller;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.service.ActiveTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/active")
@CrossOrigin
public class ActiveTimeController {

    //private static final String CREATE = "/create";
    private static final String GET_BY_ID = "/get-by-id/{id}";
    private static final String DELETE_BY_ID = "/delete-by-id/{id}";
    @Autowired
    private ActiveTimeService activeTimeService;

    /*
    @GetMapping(CREATE)
    public ActiveTime create(){
        ActiveTime activeTime = new ActiveTime();
        //TODO
        return activeTimeService.create(activeTime);
    }

     */
/*
    @GetMapping(GET_BY_ID)
    public ActiveTime getById(@PathVariable long id){
        return activeTimeService.getById(id);
    }

    @GetMapping(DELETE_BY_ID)
    public void deleteById(@PathVariable long id){
        activeTimeService.deleteById(id);
    }


 */
}
