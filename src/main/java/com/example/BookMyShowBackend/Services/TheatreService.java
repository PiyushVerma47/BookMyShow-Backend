package com.example.BookMyShowBackend.Services;

import com.example.BookMyShowBackend.Entities.Theatre;
import com.example.BookMyShowBackend.Repository.TheatreRepository;
import com.example.BookMyShowBackend.Requests.AddTheatreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
