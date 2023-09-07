package com.makemytrip.makemytrip.Transformers;

import com.makemytrip.makemytrip.RequestDtos.AddTransportRequestDto;
import com.makemytrip.makemytrip.ResponseDtos.FlightResults;
import com.makemytrip.makemytrip.models.Transport;
import lombok.Data;

public class TransportTransformer {

    public static Transport ConvertDtoToEntity(AddTransportRequestDto addTransportRequestDto){

        Transport transport = Transport.builder()
                .modeOfTransport(addTransportRequestDto.getModeOfTransport())
                .journeyDate(addTransportRequestDto.getJourneyDate())
                .journeyTime(addTransportRequestDto.getJourneyTime())
                .startTime(addTransportRequestDto.getStartTime())
                .companyName(addTransportRequestDto.getCompanyName()).build();

        return transport;
    }

    public static FlightResults ConvertEntityToFlightResult(Transport transport){

        FlightResults flightResults = FlightResults.builder().companyName(transport.getCompanyName())
                .journeyDate(transport.getJourneyDate()).journeyTime(transport.getJourneyTime())
                .startTime(transport.getStartTime()).build();

        return flightResults;
    }
}
