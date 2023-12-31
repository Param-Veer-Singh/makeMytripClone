package com.makemytrip.makemytrip.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightResults {

    private LocalDate journeyDate;
    private LocalTime startTime;
    private double journeyTime;
    private String companyName;
    private String listOfStopInBetween;
}
