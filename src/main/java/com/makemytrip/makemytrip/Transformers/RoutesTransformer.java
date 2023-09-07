package com.makemytrip.makemytrip.Transformers;

import com.makemytrip.makemytrip.RequestDtos.AddRouteRequestDto;
import com.makemytrip.makemytrip.models.Routes;

public class RoutesTransformer {

    public static Routes convertDtoToEntity(AddRouteRequestDto addRouteRequestDto){

        Routes routesObject = Routes.builder()
                                .fromCity(addRouteRequestDto.getFromCity())
                                .toCity(addRouteRequestDto.getToCity())
                                .modeOfTransport(addRouteRequestDto.getModeOfTransport())
                                .ListOfStopsInBetween(addRouteRequestDto.getListOfStopsInBetween()).build();

        return routesObject;
    }
}
