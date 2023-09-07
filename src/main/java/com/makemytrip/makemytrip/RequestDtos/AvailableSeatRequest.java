package com.makemytrip.makemytrip.RequestDtos;


import lombok.Data;

import java.time.LocalDate;

@Data
public class AvailableSeatRequest {

    private LocalDate journeyDate;
    private Integer transportId;
}
