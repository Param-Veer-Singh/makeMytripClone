package com.makemytrip.makemytrip.RequestDtos;

import com.makemytrip.makemytrip.Enums.ModeOfTransport;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AddTransportRequestDto {

    private ModeOfTransport modeOfTransport;

    private LocalDate journeyDate;

    private LocalTime startTime;

    private Double journeyTime;

    private String companyName;

    private Integer routeId;
}
