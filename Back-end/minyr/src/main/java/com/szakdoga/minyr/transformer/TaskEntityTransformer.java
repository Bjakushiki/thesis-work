package com.szakdoga.minyr.transformer;

import com.szakdoga.minyr.model.Task;
import com.szakdoga.minyr.model.User;
import com.szakdoga.minyr.persistence.entity.TaskEntity;
import com.szakdoga.minyr.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskEntityTransformer {

    @Autowired
    private UserEntityTransformer userEntityTransformer;

    public Task transform(TaskEntity entity) {
        Task task = new Task();
        task.setId(entity.getId());
        task.setName(entity.getName());
        task.setDescription(entity.getDescription());
        task.setStartDate(entity.getStartDate());
        task.setEndDate(entity.getEndDate());
        task.setStatus(entity.getStatus());
        task.setReporter(userEntityTransformer.transform(entity.getReporter()));
        if (entity.getAssignee() != null) {
            task.setAssignee(userEntityTransformer.transform(entity.getAssignee()));
        }
        task.setWorkingHours(entity.getWorkingHours());
        return task;
    }
    public List<Task> transform(List<TaskEntity> entities) {
        List<Task> tasks = new ArrayList<>();
        if (entities != null) {
            for (TaskEntity entity : entities) {
                tasks.add(transform(entity));
            }
        }
        return tasks;
    }
}
