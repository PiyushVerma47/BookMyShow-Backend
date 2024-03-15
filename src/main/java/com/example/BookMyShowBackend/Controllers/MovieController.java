package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Requests.AddMovieRequest;
import com.example.BookMyShowBackend.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity addMovie(@RequestBody AddMovieRequest addMovieRequest){

        String result = movieService.addMovie(addMovieRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/getMovieByName")
    public String getMovie(@RequestParam("movieName") String movieName){
        String result = movieService.getMovie(movieName);
        return result;
    }

    @GetMapping("/getMovieById")
    public String getMovieById(@RequestParam("movieId") int movieId){
        String result = movieService.getMovieById(movieId);
        return result;
    }
}
