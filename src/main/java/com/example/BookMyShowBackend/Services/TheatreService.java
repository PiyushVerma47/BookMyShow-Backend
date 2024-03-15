package com.example.BookMyShowBackend.Services;

import com.example.BookMyShowBackend.Entities.Movie;
import com.example.BookMyShowBackend.Entities.Theatre;
import com.example.BookMyShowBackend.Entities.TheatreSeat;
import com.example.BookMyShowBackend.Eums.SeatType;
import com.example.BookMyShowBackend.Repository.TheatreRepository;
import com.example.BookMyShowBackend.Requests.AddTheatreRequest;
import com.example.BookMyShowBackend.Requests.AddTheatreSeatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    public String addTheatre(AddTheatreRequest addTheatreRequest){
        Theatre theatre = Theatre.builder()
                .name(addTheatreRequest.getName())
                .address(addTheatreRequest.getAddress())
                .noOfScreens(addTheatreRequest.getNoOfScreens())
                .build();

        theatre = theatreRepository.save(theatre);

        return "Theatre with name "+ theatre.getName()+" and theatre Id "+ theatre.getTheatreId()+" has been saved to the db";
    }

    public String getTheatre(String theatreName){
        Theatre theatre = theatreRepository.findTheatreByName(theatreName);
        return theatre.getName();
    }

    public String getTheatreById(int theatreId){
        Theatre theatre = theatreRepository.findById(theatreId).get();
        return theatre.getName();
    }

    public String addSeats(AddTheatreSeatsRequest addTheatreSeatsRequest){
        Theatre theatre = theatreRepository.findById(addTheatreSeatsRequest.getTheatreId()).get();

        int noOfPremiumSeats = addTheatreSeatsRequest.getNoOfPremiumSeats();
        int noOfClassicSeats = addTheatreSeatsRequest.getNoOfClassicSeats();

        int quoPremium = noOfPremiumSeats/5;
        int quoClassic = noOfClassicSeats/5;

        int remPremium = noOfPremiumSeats%5;
        int remClassic = noOfClassicSeats%5;

        List<TheatreSeat> theatreSeatList = new ArrayList<>();

        char counter = 'A';

        for(int i=0;i<quoPremium;i++){
            for(int j=1;j<=5;j++){
                String seatNo = counter +""+ j;
                TheatreSeat theatreSeat = TheatreSeat.builder()
                        .seatNo(seatNo)
                        .seatType(SeatType.PREMIUM)
                        .theatre(theatre)
                        .build();
                theatreSeatList.add(theatreSeat);
            }
            counter++;
        }

        for(int i=1;i<=remPremium;i++){
            String seatNo = counter+""+i;
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theatre(theatre)
                    .build();
            theatreSeatList.add(theatreSeat);
        }
        counter++;

        for(int i=0;i<quoClassic;i++){
            for(int j=1;j<=5;j++){
                String seatNo = counter +""+ j;
                TheatreSeat theatreSeat = TheatreSeat.builder()
                        .seatNo(seatNo)
                        .seatType(SeatType.CLASSIC)
                        .theatre(theatre)
                        .build();
                theatreSeatList.add(theatreSeat);
            }
            counter++;
        }

        for(int i=1;i<=remClassic;i++){
            String seatNo = counter+""+i;
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theatre(theatre)
                    .build();
            theatreSeatList.add(theatreSeat);
        }
        counter++;

        theatre.setTheatreSeatList(theatreSeatList);
        theatreRepository.save(theatre);

        return "Theatre Seats have been added to the theatre "+ theatre.getName() ;
    }
}
