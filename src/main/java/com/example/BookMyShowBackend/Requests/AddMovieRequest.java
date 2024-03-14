package com.example.BookMyShowBackend.Requests;

import com.example.BookMyShowBackend.Eums.Genre;
import com.example.BookMyShowBackend.Eums.Language;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieRequest {

    private String movieName;
    private Genre genre;
    private Language movieLanguage;
    private LocalDate releaseDate;
    private double duration;

}
