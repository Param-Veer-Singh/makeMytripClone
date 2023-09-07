package com.makemytrip.makemytrip.Repository;

import com.makemytrip.makemytrip.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
}
