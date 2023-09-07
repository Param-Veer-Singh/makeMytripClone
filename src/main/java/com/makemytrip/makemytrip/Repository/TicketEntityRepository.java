package com.makemytrip.makemytrip.Repository;

import com.makemytrip.makemytrip.models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketEntityRepository extends JpaRepository<TicketEntity, Integer> {
}
