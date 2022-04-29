package com.szakdoga.minyr.controller;

import com.szakdoga.minyr.model.Status;
import com.szakdoga.minyr.model.Task;
import com.szakdoga.minyr.service.TaskService;
import com.szakdoga.minyr.service.UserService;
import com.szakdoga.minyr.view.CreateTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin
public class TaskController {

    private static final String CREATE = "/create";
    private static final String DELETE_BY_ID = "/delete-by-id/{id}";
    private static final String GET_BY_ID = "get-by-user-id/{id}";
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @PutMapping(CREATE)
    public String create(@RequestBody CreateTaskRequest taskRequest){
        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setDescription(taskRequest.getDescription());
        task.setReporter(userService.getById(taskRequest.getReporterId()));
        task.setAssignee(userService.getById(taskRequest.getAssigneeId()));
        if (taskService.create(task)){
            return "Sikeres mentés";
        }else {
            return "Hiba a mentésben";
        }
    }

    /*
    @GetMapping(DELETE_BY_ID)
    public void deleteById(@PathVariable long id){
        taskService.deleteById(id);
    }


     */
    @GetMapping(GET_BY_ID)
    public List<Task> getByUserId(@PathVariable long id){
        return taskService.getByUserId(id);
    }



    @PutMapping("/update")
    public String update(@RequestBody CreateTaskRequest createTaskRequest){
        Task task = new Task();
        if (createTaskRequest.getName() != null){
            task = taskService.getByName(createTaskRequest.getName());
            task.setName(createTaskRequest.getName());
            if (task.getStatus() == Status.FINISHED){
                return "A módosítani kívánt task már befejezett";
            }
        }
        if (createTaskRequest.getDescription() != null){ task.setDescription(createTaskRequest.getDescription()); }
        //if (createTaskRequest.getStartDate() != null){ task.setStartDate(createTaskRequest.getStartDate()); }
        //if (createTaskRequest.getEndDate() != null){ task.setEndDate(createTaskRequest.getEndDate()); }
        if (createTaskRequest.getStatus() != null){ task.setStatus(createTaskRequest.getStatus()); }
        //if (createTaskRequest.getReporterId() != 0){ task.setReporter(userService.getById(createTaskRequest.getReporterId())); }
        if (createTaskRequest.getAssigneeId() != 0){ task.setAssignee(userService.getById(createTaskRequest.getAssigneeId())); }
        //if (createTaskRequest.getWorkingHours() != null){ task.setWorkingHours(createTaskRequest.getWorkingHours()); }1
        if (taskService.update(task,createTaskRequest.getReporterId())){
            return "Sikeres mentés";
        }else {
            return "Hiba a mentésben";
        }

    }

    @GetMapping("/get-working-hour/{id}")
    public Long getWorkingHourById(@PathVariable long id){
        return taskService.getWorkinHourById(id);
    }
}
