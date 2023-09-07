package com.makemytrip.makemytrip.RequestDtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {

    private String seatNo;

    private LocalDate journeyDate;

    private Integer transportId;

    private Integer userId;
}
