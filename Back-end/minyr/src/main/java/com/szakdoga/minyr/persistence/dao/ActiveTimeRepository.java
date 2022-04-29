package com.szakdoga.minyr.persistence.dao;

import com.szakdoga.minyr.persistence.entity.ActiveTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveTimeRepository extends JpaRepository<ActiveTimeEntity, Long> {
    ActiveTimeEntity deleteById(long id);
}
