package com.makemytrip.makemytrip.Controllers;

import com.makemytrip.makemytrip.Repository.BookingsRepository;
import com.makemytrip.makemytrip.RequestDtos.AvailableSeatRequest;
import com.makemytrip.makemytrip.ResponseDtos.AvailableSeatResponse;
import com.makemytrip.makemytrip.Service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("booking")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    @GetMapping("/getAvailableSeats")
    private List<AvailableSeatResponse> getAvailableSeats(@RequestBody AvailableSeatRequest availableSeatRequest){

        return bookingsService.getAvailableSeats(availableSeatRequest);
    }
}
