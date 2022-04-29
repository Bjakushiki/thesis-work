package com.szakdoga.minyr.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class User {
    private long id;
    private String name;
    private String passwd;
    private List<ActiveTime> activeTimes;
    private Vacation vacation;
    private Boolean isAdmin;
}
