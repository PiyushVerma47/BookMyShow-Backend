package com.example.BookMyShowBackend.Services;

import com.example.BookMyShowBackend.Entities.Show;
import com.example.BookMyShowBackend.Entities.ShowSeat;
import com.example.BookMyShowBackend.Entities.Ticket;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.TicketRepository;
import com.example.BookMyShowBackend.Requests.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;


    public String bookTicket(BookTicketRequest bookTicketRequest) throws Exception{
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();

        List<ShowSeat> showSeatList = show.getShowSeatList();
        int totalBill = 0;

        for(String seatNoToBeBooked : bookTicketRequest.getSeatList()){

            for(ShowSeat showSeat:showSeatList){

                if(showSeat.getSeatNo().equals(seatNoToBeBooked)){

                    if(showSeat.isAvailable()){
                        showSeat.setAvailable(Boolean.FALSE);
                        totalBill += showSeat.getPrice();
                    }else{
                        throw new Exception("Seat No "+showSeat.getSeatNo()+" is already booked.");
                    }
                }
            }
        }



        Ticket ticket = Ticket.builder()
                .seatNosBooked(bookTicketRequest.getSeatList().toString())
                .totalAmountPaid(totalBill)
                .show(show)
                .build();

        show.getTicketList().add(ticket);
        ticket = ticketRepository.save(ticket);

        return "Ticket for the movie: "+ show.getMovie().getMovieName() +" has been booked with the ticket Id: "+ticket.getTicketId()+" and total bill generated if of Rs." + ticket.getTotalAmountPaid();
    }

}