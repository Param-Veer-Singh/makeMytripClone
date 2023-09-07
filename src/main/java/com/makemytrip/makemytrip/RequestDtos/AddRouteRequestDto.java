package com.makemytrip.makemytrip.RequestDtos;

import com.makemytrip.makemytrip.Enums.City;
import com.makemytrip.makemytrip.Enums.ModeOfTransport;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AddRouteRequestDto {

    private City fromCity;

    private City toCity;

    private String ListOfStopsInBetween;

    private ModeOfTransport modeOfTransport;
}
