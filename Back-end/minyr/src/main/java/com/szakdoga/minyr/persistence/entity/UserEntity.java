package com.szakdoga.minyr.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String passwd;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //@Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<ActiveTimeEntity> activeTimes;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    private VacationEntity vacation;
    private Boolean isAdmin;
}

