package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    Theatre findTheatreByName(String name);
}
