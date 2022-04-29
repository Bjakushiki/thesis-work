package com.szakdoga.minyr.transformer;

import com.szakdoga.minyr.model.Task;
import com.szakdoga.minyr.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskTransformer {

    @Autowired
    private UserTransformer userTransformer;

    public TaskEntity transform(Task task){
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(task.getId());
        taskEntity.setName(task.getName());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setStartDate(task.getStartDate());
        taskEntity.setEndDate(task.getEndDate());
        taskEntity.setStatus(task.getStatus());
        taskEntity.setReporter(userTransformer.transform(task.getReporter()));
        if (task.getAssignee() != null) {
            taskEntity.setAssignee(userTransformer.transform(task.getAssignee()));
        }
        taskEntity.setWorkingHours(task.getWorkingHours());
        return taskEntity;
    }
}
