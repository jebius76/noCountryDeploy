package com.c1331tjava.ServiceApp.dto;

import com.c1331tjava.ServiceApp.model.UserEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BidDTO {
    private Long id;
    private BidProviderDTO provider;
    private String response;
    private Float budget;
    private LocalDateTime date;
    private String comments;
    private Boolean interviewed;
}
