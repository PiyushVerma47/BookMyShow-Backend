package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
