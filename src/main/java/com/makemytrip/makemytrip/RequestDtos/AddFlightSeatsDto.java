package com.makemytrip.makemytrip.RequestDtos;

import com.makemytrip.makemytrip.Enums.SeatType;
import lombok.Data;

@Data
public class AddFlightSeatsDto {

    private int noOfEconomyClassSeats;
    private int noOfBusinessClassSeats;

    private int priceOfEconomyClassSeat;
    private int priceOfBusinessClassSeat;

    private int transportId;
}
