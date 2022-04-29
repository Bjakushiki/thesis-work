package com.szakdoga.minyr.persistence.dao;

import com.szakdoga.minyr.model.Status;
import com.szakdoga.minyr.model.User;
import com.szakdoga.minyr.persistence.entity.TaskEntity;
import com.szakdoga.minyr.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static com.szakdoga.minyr.model.Status.IN_PROGRESS;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    TaskEntity findById(long id);
    TaskEntity findByName(String name);
    TaskEntity findByAssignee(UserEntity user);
    TaskEntity findByAssigneeAndStatus(UserEntity user, Status status );
    List<TaskEntity> findAllByAssignee(UserEntity user);
}
