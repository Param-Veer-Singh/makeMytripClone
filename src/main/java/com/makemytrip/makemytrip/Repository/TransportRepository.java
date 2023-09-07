package com.makemytrip.makemytrip.Repository;

import com.makemytrip.makemytrip.models.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport,Integer> {
}
