package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieName(String movieName);
}
