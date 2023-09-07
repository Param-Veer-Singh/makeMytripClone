package com.makemytrip.makemytrip.Controllers;


import com.makemytrip.makemytrip.RequestDtos.AddTransportRequestDto;
import com.makemytrip.makemytrip.RequestDtos.SearchFlightsDto;
import com.makemytrip.makemytrip.ResponseDtos.FlightResults;
import com.makemytrip.makemytrip.Service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    private TransportService transportService;

    @PostMapping("/add")
    public String addTransport(@RequestBody AddTransportRequestDto addTransportRequestDto) throws Exception {
        return transportService.addTransport(addTransportRequestDto);
    }

    @GetMapping("/searchFlights")
    public List<FlightResults> searchFlights (@RequestBody SearchFlightsDto searchFlightDto){

        return transportService.searchFlights(searchFlightDto);
    }
}
