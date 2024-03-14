package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Requests.AddTheatreRequest;
import com.example.BookMyShowBackend.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
