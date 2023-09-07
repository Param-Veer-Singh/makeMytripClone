package com.makemytrip.makemytrip.Repository;

import com.makemytrip.makemytrip.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings,Integer> {
    @Query(value = "select * from bookings where journeyDate =:journeyDateInput and transportId =:transportIdInput",nativeQuery = true)
    List<Bookings> findBookings(LocalDate journeyDateInput, Integer transportIdInput);
}

