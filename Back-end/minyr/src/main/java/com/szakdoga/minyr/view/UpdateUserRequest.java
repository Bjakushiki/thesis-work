package com.szakdoga.minyr.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequest {
    private long id;
    private String name;
    private String passwd;
}
