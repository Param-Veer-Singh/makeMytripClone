package com.makemytrip.makemytrip.RequestDtos;


import com.makemytrip.makemytrip.Enums.City;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchFlightsDto {

    private City fromCity;

    private City toCity;

    private LocalDate journeyDate;
}
