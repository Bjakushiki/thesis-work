package com.szakdoga.minyr.persistence.dao;

import com.szakdoga.minyr.model.Vacation;
import com.szakdoga.minyr.persistence.entity.UserEntity;
import com.szakdoga.minyr.persistence.entity.VacationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity , Long> {
    UserEntity findById(long id);
    UserEntity getAllByName(String name);
    UserEntity findByNameAndPasswd(String name, String passwd);
    UserEntity findByVacation(VacationEntity vacation);
}
