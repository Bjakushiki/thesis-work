package com.szakdoga.minyr.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Local;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class ActiveTimeEntity {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime arrival;
    private LocalDateTime departure;
}
