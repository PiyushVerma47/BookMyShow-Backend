package com.example.BookMyShowBackend.Services;

import com.example.BookMyShowBackend.Entities.*;
import com.example.BookMyShowBackend.Eums.SeatType;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.ShowSeatRepository;
import com.example.BookMyShowBackend.Repository.TheatreRepository;
import com.example.BookMyShowBackend.Requests.AddMovieRequest;
import com.example.BookMyShowBackend.Requests.AddShowRequest;
import com.example.BookMyShowBackend.Requests.AddShowSeatRequest;
import com.example.BookMyShowBackend.Requests.GetShowDetailRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

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


    public String addShowSeats(AddShowSeatRequest addShowSeatRequest){
        Show show = showRepository.findById(addShowSeatRequest.getShowId()).get();
        Theatre theatre = show.getTheatre();
        List<TheatreSeat> theatreSeatList = theatre.getTheatreSeatList();

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheatreSeat theatreSeat : theatreSeatList){
            String seatNo = theatreSeat.getSeatNo();
            SeatType seatType = theatreSeat.getSeatType();

            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(seatNo)
                    .seatType(seatType)
                    .isAvailable(true)
                    .foodAttached(false)
                    .show(show)
                    .build();

            if(seatType.equals(SeatType.PREMIUM)) {
                showSeat.setPrice(addShowSeatRequest.getPriceForPremiumSeats());
            }
            else{
                showSeat.setPrice(addShowSeatRequest.getPriceForClassicSeats());
            }

            showSeatList.add(showSeat);
        }

        showSeatRepository.saveAll(showSeatList);

        return "Seats of the show: " + show.getMovie().getMovieName() +" with the show Id: "+ show.getShowId()+" have been added";

    }

    public String getShowDetail(GetShowDetailRequest getShowDetailRequest){
        Show show = showRepository.findById(getShowDetailRequest.getShowId()).get();
        return show.getShowId()+" "+show.getMovie().getMovieName() ;
    }
}
