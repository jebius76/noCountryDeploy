package com.c1331tjava.ServiceApp.dto.client;

import com.c1331tjava.ServiceApp.model.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class RequestDTO {
    private Long id;
    private LocalDateTime date;
    private Zone zone;
    private String description;
    private Set<ImagesR> images;
    private Set<BidDTO> bids;
    private String comments;
    private Boolean ended;
}
