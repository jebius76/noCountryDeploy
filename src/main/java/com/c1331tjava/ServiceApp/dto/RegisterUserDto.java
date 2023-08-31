package com.c1331tjava.ServiceApp.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * A Data Transfer Object (DTO) representing the information needed to register a new user.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDto {


    @NotNull
    private String userName;
    @NotNull
    private String userLastname;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @NotNull
    private Date birthDate;
    @NotNull
    private String te;
    @Nullable
    private List<Long> areas;
    @NotNull
    private List<Long> roles;
}

