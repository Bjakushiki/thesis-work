package com.szakdoga.minyr.persistence.dao;

import com.szakdoga.minyr.persistence.entity.VacationEntity;
import com.szakdoga.minyr.persistence.entity.VacationTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<VacationEntity, Long> {
    VacationEntity findById(long id);
}
