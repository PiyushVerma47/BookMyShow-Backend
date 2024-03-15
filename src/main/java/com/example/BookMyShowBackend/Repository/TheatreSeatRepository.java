package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Entities.TheatreSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeat, Integer> {
}
