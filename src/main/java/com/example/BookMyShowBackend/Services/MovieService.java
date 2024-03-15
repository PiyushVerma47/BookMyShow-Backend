package com.example.BookMyShowBackend.Services;

import com.example.BookMyShowBackend.Entities.Movie;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import com.example.BookMyShowBackend.Requests.AddMovieRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest addMovieRequest){
        Movie movie = Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .movieLanguage(addMovieRequest.getMovieLanguage())
                .releaseDate(addMovieRequest.getReleaseDate())
                .duration(addMovieRequest.getDuration())
                .build();

        movie = movieRepository.save(movie);

        return "Movie with movie name "+ movie.getMovieName()+ " and movie Id " + movie.getMovieId() +" has been saved to the db";
    }

    public String getMovie(String movieName){
        Movie movie = movieRepository.findMovieByMovieName(movieName);
        return movie.getMovieName();
    }

    public String getMovieById(int movieId){
        Movie movie = movieRepository.findById(movieId).get();
        return movie.getMovieName();
    }
}
