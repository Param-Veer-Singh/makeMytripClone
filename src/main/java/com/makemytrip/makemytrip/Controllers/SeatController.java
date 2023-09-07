package com.makemytrip.makemytrip.Controllers;

import com.makemytrip.makemytrip.RequestDtos.AddFlightSeatsDto;
import com.makemytrip.makemytrip.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/addFlightSeats")
    public String addFlightSeats(AddFlightSeatsDto addFlightSeatsDto){
        return seatService.addFlightSeats(addFlightSeatsDto);
    }
}
