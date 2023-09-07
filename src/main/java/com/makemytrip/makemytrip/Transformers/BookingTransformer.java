package com.makemytrip.makemytrip.Transformers;

import com.makemytrip.makemytrip.RequestDtos.BookingRequest;
import com.makemytrip.makemytrip.models.Bookings;

public class BookingTransformer {

    public static Bookings ConvertRequestToEntity(BookingRequest bookingRequest){

        Bookings bookings = Bookings.builder()
                .journeyDate(bookingRequest.getJourneyDate())
                .seatNo(bookingRequest.getSeatNo())
                .transportId(bookingRequest.getTransportId())
                .build();

        return bookings;
    }
}
