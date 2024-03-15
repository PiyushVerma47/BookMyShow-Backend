package com.example.BookMyShowBackend.Services;

import com.example.BookMyShowBackend.Entities.Movie;
import com.example.BookMyShowBackend.Entities.Show;
import com.example.BookMyShowBackend.Entities.Theatre;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.TheatreRepository;
import com.example.BookMyShowBackend.Requests.AddMovieRequest;
import com.example.BookMyShowBackend.Requests.AddShowRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    public String addShow(AddShowRequest addShowRequest){
        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());


        Theatre theatre = theatreRepository.findById(addShowRequest.getTheatreId()).get();

//        Optional<Theatre> theaterOptional = theatreRepository.findById(addShowRequest.getTheatreId());
//        Theatre theatre = theaterOptional.get();

        Show show = Show.builder()
                .showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .build();

        show.setMovie(movie);
        show.setTheatre(theatre);

        movie.getShowList().add(show);
        theatre.getShowList().add(show);

        show = showRepository.save(show);

        return "Show with the movie name: " + movie.getMovieName() + " has been added to the theatre: " + theatre.getName() + " with show Id : "+show.getShowId();

    }

//    public String addShow(AddShowRequest addShowRequest) {
//
//        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
//
////        if(movie==null) {
////            throw new Exception("Movie Name entered does not exist in the DB");
////        }
//
////        Optional<Theatre> theatreOptional = theatreRepository.findById(addShowRequest.getTheatreId());
//////        if(theatreOptional.isEmpty()){
//////            throw new Exception("Theater Id entered is incorrect");
//////        }
////        Theatre theatre = theatreOptional.get();
//
//        Theatre theatre = theatreRepository.findById(addShowRequest.getTheatreId()).get();
//
//        //Ideally you should create the show Entity with the help of Transformers
//        Show showEntity = new Show(addShowRequest.getShowDate(),addShowRequest.getShowTime());
//
//        showEntity.setMovie(movie);
//        showEntity.setTheatre(theatre);
//
//        //Bidirectional in the parent class
//        movie.getShowList().add(showEntity);
//        theatre.getShowList().add(showEntity);
//        showEntity =  showRepository.save(showEntity);
////        return "The show has been created with the showId "+showEntity.getShowId();
//        return "Show with the movie name: " + movie.getMovieName() + " has been added to the theatre: " + theatre.getName() + " with show Id : "+showEntity.getShowId();
//
//    }
}
