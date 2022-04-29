package com.szakdoga.minyr.service;

import com.szakdoga.minyr.model.ActiveTime;
import com.szakdoga.minyr.model.Status;
import com.szakdoga.minyr.model.Task;
import com.szakdoga.minyr.model.User;
import com.szakdoga.minyr.persistence.dao.TaskRepository;
import com.szakdoga.minyr.persistence.dao.UserRepository;
import com.szakdoga.minyr.persistence.entity.TaskEntity;
import com.szakdoga.minyr.persistence.entity.UserEntity;
import com.szakdoga.minyr.transformer.TaskEntityTransformer;
import com.szakdoga.minyr.transformer.TaskTransformer;
import com.szakdoga.minyr.transformer.UserTransformer;
import com.szakdoga.minyr.view.CreateTaskRequest;
import com.szakdoga.minyr.view.UpdateTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskEntityTransformer taskEntityTransformer;
    @Autowired
    private TaskTransformer taskTransformer;
    @Autowired
    private UserService userService;
    @Autowired
    private UserTransformer userTransformer;
    @Autowired
    private UserRepository userRepository;

    public Boolean create(Task task){
        task.setStatus(Status.TODO);
        task.setStartDate(LocalDateTime.now());

        if (taskEntityTransformer.transform(taskRepository.save(taskTransformer.transform(task))) != null){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    public Task getByName(String name) {return taskEntityTransformer.transform(taskRepository.findByName(name));}
    public Task getById(long id){
        return taskEntityTransformer.transform(taskRepository.findById(id));
    }
    public List<Task> getByUserId(long id){
        UserEntity userEntity = userRepository.findById(id);

        return taskEntityTransformer.transform(taskRepository.findAllByAssignee(userEntity));
    }

    public void deleteById(long id){
        taskRepository.deleteById(id);
    }

    public void updateById( long id, UpdateTaskRequest updateTaskRequest){

        Task task = taskEntityTransformer.transform(taskRepository.findById(id));

        task.setName(updateTaskRequest.getName());
        task.setDescription(updateTaskRequest.getDescription());
        task.setStartDate(updateTaskRequest.getStartDate());
        task.setEndDate(updateTaskRequest.getEndDate());
        task.setReporter(updateTaskRequest.getReporter());
        task.setAssignee(updateTaskRequest.getAssignee());
        task.setStatus(updateTaskRequest.getStatus());

        taskRepository.save(taskTransformer.transform(task));

    }

    public Boolean update(Task task, long userid){
        if (task.getReporter().getId() == userid){
            taskEntityTransformer.transform(taskRepository.save(taskTransformer.transform(task)));
        }
        if (task.getStatus() == Status.FINISHED){
            task.setEndDate(LocalDateTime.now());
        }
        if (taskEntityTransformer.transform(taskRepository.save(taskTransformer.transform(task))) != null){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }

    }

    public void updateWorkingHourByUserId(long id){
        User user = userService.getById(id);

        TaskEntity taskEntity = taskRepository.findByAssigneeAndStatus(userTransformer.transform(user),Status.TODO);
        if (taskEntity != null){
        Task task = taskEntityTransformer.transform(taskEntity);
        ActiveTime activeTime = user.getActiveTimes().get(user.getActiveTimes().size()-1);
        if (task.getWorkingHours() == null){
            task.setWorkingHours(Duration.between(task.getStartDate(),activeTime.getDeparture()));
        }
        else {
            Duration duration = Duration.between(activeTime.getArrival(),activeTime.getDeparture());
            task.setWorkingHours(task.getWorkingHours().plus(duration));
        }
        taskRepository.save(taskTransformer.transform(task));
    }

    }
    public Long getWorkinHourById(long id){
        Task task = taskEntityTransformer.transform(taskRepository.findById(id));
        Long time = task.getWorkingHours().toHours();
        return time;
    }

}
