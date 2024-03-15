package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Requests.AddTheatreRequest;
import com.example.BookMyShowBackend.Requests.AddTheatreSeatsRequest;
import com.example.BookMyShowBackend.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theatre")
public class theatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/addTheatre")
    public String addTheatre(@RequestBody AddTheatreRequest addTheatreRequest){

        String result = theatreService.addTheatre(addTheatreRequest);
        return result;

    }


    @GetMapping("/getTheatreByName")
    public String getTheatre(@RequestParam("theatreName") String theatreName){
        String result = theatreService.getTheatre(theatreName);
        return result;
    }

    @GetMapping("/getTheatreById")
    public String getTheatreById(@RequestParam("theatreId") int theatreId){
        String result = theatreService.getTheatreById(theatreId);
        return result;
    }


    @PostMapping("/addTheatreSeats")
    public String addSeats(@RequestBody AddTheatreSeatsRequest addTheatreSeatsRequest){
        String result = theatreService.addSeats(addTheatreSeatsRequest);
        return result;
    }
}
