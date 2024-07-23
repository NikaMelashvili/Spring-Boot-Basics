package com.melashvili.fullangdemo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDTO {
    private Long id;
    private String email;
    private String password;
}
