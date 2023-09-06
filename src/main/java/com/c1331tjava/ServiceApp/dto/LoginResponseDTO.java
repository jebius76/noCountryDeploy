package com.c1331tjava.ServiceApp.dto;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponseDTO {

    private String userName;
    private String lastName;
    private List<String> roles;

}
