package com.example.BookMyShowBackend.Controllers;

import com.example.BookMyShowBackend.Requests.BookTicketRequest;
import com.example.BookMyShowBackend.Responses.ViewTicketResponse;
import com.example.BookMyShowBackend.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequest bookTicketRequest){
        try{
            String result = ticketService.bookTicket(bookTicketRequest);
            return new ResponseEntity(result, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/viewTicket")
    public ViewTicketResponse viewTicket(@RequestParam("ticketId") int ticketId){
        ViewTicketResponse viewTicketResponse = ticketService.viewTicket(ticketId);
        return viewTicketResponse;
    }

}
