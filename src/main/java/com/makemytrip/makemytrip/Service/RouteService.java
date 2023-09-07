package com.makemytrip.makemytrip.Service;


import com.makemytrip.makemytrip.Repository.RouteRepository;
import com.makemytrip.makemytrip.RequestDtos.AddRouteRequestDto;
import com.makemytrip.makemytrip.Transformers.RoutesTransformer;
import com.makemytrip.makemytrip.models.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public String addRoute(AddRouteRequestDto addRouteRequestDto){

        Routes routes = RoutesTransformer.convertDtoToEntity(addRouteRequestDto);
        routeRepository.save(routes);

        return "Route has been added successfully";

    }
}
