package com.makemytrip.makemytrip.Repository;

import com.makemytrip.makemytrip.Enums.City;
import com.makemytrip.makemytrip.Enums.ModeOfTransport;
import com.makemytrip.makemytrip.models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Routes,Integer> {

    List<Routes> findRoutesByFromCityAndToCityAndModeOfTransport(City fromCity, City toCity, ModeOfTransport modeOfTransport);

}
