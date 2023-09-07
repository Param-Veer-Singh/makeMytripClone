package com.makemytrip.makemytrip.Service;


import com.makemytrip.makemytrip.Repository.RouteRepository;
import com.makemytrip.makemytrip.Repository.TransportRepository;
import com.makemytrip.makemytrip.RequestDtos.AddTransportRequestDto;
import com.makemytrip.makemytrip.RequestDtos.SearchFlightsDto;
import com.makemytrip.makemytrip.ResponseDtos.FlightResults;
import com.makemytrip.makemytrip.Transformers.TransportTransformer;
import com.makemytrip.makemytrip.models.Routes;
import com.makemytrip.makemytrip.models.Transport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.makemytrip.makemytrip.Enums.ModeOfTransport.FLIGHT;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private RouteRepository routeRepository;

    public String addTransport(AddTransportRequestDto addTransportRequestDto) throws Exception {

        Optional<Routes> optionalRoutes = routeRepository.findById(addTransportRequestDto.getRouteId());
        if(!optionalRoutes.isPresent()){
            throw new Exception("Route id is incorrect");
        }

        Routes route = optionalRoutes.get();
        Transport transport = TransportTransformer.ConvertDtoToEntity(addTransportRequestDto);
        transport.setRoutes(route);
        route.getTransportList().add(transport);

        routeRepository.save(route);

        return "Transport added successfully";
    }

    public List<FlightResults> searchFlights(SearchFlightsDto searchFlightsDto){

        List<Routes> listOfFlights = routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(searchFlightsDto.getFromCity(), searchFlightsDto.getToCity() , FLIGHT);

        List<FlightResults> flightResults = new ArrayList<>();

        for(Routes routes : listOfFlights){

            List<Transport> transports = routes.getTransportList();

            for (Transport transport : transports){
                if(transport.getJourneyDate().equals(searchFlightsDto.getJourneyDate())){
                    FlightResults flight = TransportTransformer.ConvertEntityToFlightResult(transport);
                    flight.setListOfStopInBetween(routes.getListOfStopsInBetween());
                    flightResults.add(flight);
                }
            }
        }
        return  flightResults;
    }
}
