package com.c1331tjava.ServiceApp.dto.client;

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
