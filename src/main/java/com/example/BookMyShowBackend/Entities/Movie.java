package com.example.BookMyShowBackend.Entities;

import com.example.BookMyShowBackend.Eums.Genre;
import com.example.BookMyShowBackend.Eums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String movieId;

    @Column(unique = true,nullable = false)
    private String movieName;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Enumerated(value = EnumType.STRING)
    private Language movieLanguage;

    private LocalDate releaseDate;

    private double duration;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();
}
