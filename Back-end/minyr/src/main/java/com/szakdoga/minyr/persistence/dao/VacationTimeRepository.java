package com.szakdoga.minyr.persistence.dao;

import com.szakdoga.minyr.model.VacationTime;
import com.szakdoga.minyr.persistence.entity.TaskEntity;
import com.szakdoga.minyr.persistence.entity.VacationTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationTimeRepository extends JpaRepository<VacationTimeEntity, Long> {
}
