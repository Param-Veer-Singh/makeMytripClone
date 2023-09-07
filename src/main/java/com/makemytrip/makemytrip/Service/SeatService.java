package com.makemytrip.makemytrip.Service;

import com.makemytrip.makemytrip.Enums.SeatType;
import com.makemytrip.makemytrip.Repository.SeatRepository;
import com.makemytrip.makemytrip.Repository.TransportRepository;
import com.makemytrip.makemytrip.RequestDtos.AddFlightSeatsDto;
import com.makemytrip.makemytrip.models.Seat;
import com.makemytrip.makemytrip.models.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private SeatRepository seatRepository;

    public String addFlightSeats(AddFlightSeatsDto addFlightSeatsDto){

        Transport transport = transportRepository.findById(addFlightSeatsDto.getTransportId()).get();


        for(int i=1;i<= addFlightSeatsDto.getNoOfEconomyClassSeats();i++){

            Seat seat = Seat.builder().seatNo("E"+i)
                    .seatType(SeatType.ECONOMY)
                    .price(addFlightSeatsDto.getPriceOfEconomyClassSeat())
                    .transport(transport)
                    .build();

            transport.getSeatList().add(seat);
        }

        for(int i=1;i<=addFlightSeatsDto.getNoOfBusinessClassSeats();i++){

            Seat seat = Seat.builder().seatNo(String.valueOf("B"+i))
                    .seatType(SeatType.BUSINESS)
                    .price(addFlightSeatsDto.getPriceOfBusinessClassSeat())
                    .transport(transport)
                    .build();

            transport.getSeatList().add(seat);

        }
        transportRepository.save(transport);
        return "Defined seats have been added";
    }
}
