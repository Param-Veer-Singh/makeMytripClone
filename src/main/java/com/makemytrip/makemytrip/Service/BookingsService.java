package com.makemytrip.makemytrip.Service;

import com.makemytrip.makemytrip.Repository.BookingsRepository;
import com.makemytrip.makemytrip.Repository.TransportRepository;
import com.makemytrip.makemytrip.Repository.UserRepository;
import com.makemytrip.makemytrip.RequestDtos.AvailableSeatRequest;
import com.makemytrip.makemytrip.RequestDtos.BookingRequest;
import com.makemytrip.makemytrip.ResponseDtos.AvailableSeatResponse;
import com.makemytrip.makemytrip.Transformers.BookingTransformer;
import com.makemytrip.makemytrip.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class BookingsService {

    @Autowired
    private BookingsRepository bookingsRepository;

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private UserRepository userRepository;

    public List<AvailableSeatResponse> getAvailableSeats (AvailableSeatRequest availableSeatRequest){

        List<Bookings> doneBookings = bookingsRepository.findBookings(availableSeatRequest.getJourneyDate(),availableSeatRequest.getTransportId());
        Set<String> bookedSeats = new TreeSet<>();
        for(Bookings booking:doneBookings){
            String str = booking.getSeatNo(); //1E,2E,3B,4B
            String[] bookedSeatsInThatBooking = str.split(",");

            for(String seatNo : bookedSeatsInThatBooking){
                bookedSeats.add(seatNo);
            }
        }

        Transport transport = transportRepository.findById(availableSeatRequest.getTransportId()).get();
        List<Seat> seatList = transport.getSeatList();
        //Total seats - Booked Seats :
        List<AvailableSeatResponse> finalAvailableSeats = new ArrayList<>();
        for(Seat seat : seatList){

            if(bookedSeats.contains(seat.getSeatNo())){
                continue;
            }
            else{
                //We will be building that response object
                AvailableSeatResponse availableSeat  = AvailableSeatResponse.builder()
                        .seatPrice(seat.getPrice())
                        .seatType(seat.getSeatType())
                        .seatNo(seat.getSeatNo())
                        .build();

                finalAvailableSeats.add(availableSeat);
            }
        }
        return finalAvailableSeats;
    }


    public String makeABooking(BookingRequest bookingRequest){

        User userObj = userRepository.findById(bookingRequest.getUserId()).get();
        Transport transportObj = transportRepository.findById(bookingRequest.getTransportId()).get();

        Bookings booking = BookingTransformer.ConvertRequestToEntity(bookingRequest);

        TicketEntity ticketEntity = createTicketEntity(transportObj,bookingRequest);


        //Set the FK
        booking.setTransport(transportObj);
        booking.setUser(userObj);
        booking.setTicketEntity(ticketEntity);



        //Setting the bidirectional mappings
        //Setting for ticket
        ticketEntity.setBookings(booking);

        //Setting the booking obj in the transport
        transportObj.getBookings().add(booking);

        //Setting the booking obj in the userObject
        userObj.getBookingsList().add(booking);


        //Save kaise kroge figure out krna ////

        return null;

    }

    private TicketEntity createTicketEntity(Transport transport,BookingRequest bookingRequest){

        Integer totalPricePaid = findTotalPricePaid(transport,bookingRequest.getSeatNo());
        String routeDetails = getRouteDetails(transport);

        TicketEntity ticketEntity = TicketEntity.builder().allSeatNo(bookingRequest.getSeatNo())
                .journeyDate(bookingRequest.getJourneyDate())
                .startTime(transport.getStartTime())
                .routeDetails(routeDetails)
                .totalCostPaid(totalPricePaid)
                .build();

        return ticketEntity;
    }

    private String getRouteDetails(Transport transport){

        //"DELHI TO BANGALORE"
        Routes routes = transport.getRoutes();
        String result = routes.getFromCity() + " TO "+routes.getToCity();
        return result;

    }

    private Integer findTotalPricePaid(Transport transport,String seatNos){

        //TODO Function to find the total price for all
        //INTERESTING : PLEASE TRY THIS
        return 0;
    }

}
