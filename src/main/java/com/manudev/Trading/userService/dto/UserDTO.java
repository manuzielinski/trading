package com.manudev.Trading.userService.dto;

import com.manudev.Trading.userService.domain.USER_ROLE;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long userID;
    private String username;
    private String password;
    private String email;
    private USER_ROLE userRole;
}

