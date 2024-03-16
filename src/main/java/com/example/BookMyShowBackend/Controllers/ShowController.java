package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Requests.AddShowRequest;
import com.example.BookMyShowBackend.Requests.AddShowSeatRequest;
import com.example.BookMyShowBackend.Requests.GetShowDetailRequest;
import com.example.BookMyShowBackend.Services.ShowService;
import com.example.BookMyShowBackend.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @Autowired
    private TicketService ticketService;

//    @PostMapping("/addShow")
//    public String addShow(@RequestBody AddShowRequest addShowRequest){
//        String result = showService.addShow(addShowRequest);
//        return result;
//    }

    @PostMapping("addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest){

//        try {
//            String result = showService.addShow(addShowRequest);
//            return new ResponseEntity(result, HttpStatus.OK);
//
//        }catch (Exception e) {
//            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }

        String result = showService.addShow(addShowRequest);
//        return new ResponseEntity(result, HttpStatus.OK);
        return result;
    }


    @PostMapping("/addShowSeats")
    public ResponseEntity addShowSeats(@RequestBody AddShowSeatRequest addShowSeats){

        System.out.println("in show controlller");

        String result = showService.addShowSeats(addShowSeats);
        return new ResponseEntity(result,HttpStatus.OK);

    }

    @PostMapping("/getShowDetail")
    public String getShowDetail(@RequestBody GetShowDetailRequest getShowDetailRequest){
        String result = showService.getShowDetail(getShowDetailRequest);
        return result;
    }


}
