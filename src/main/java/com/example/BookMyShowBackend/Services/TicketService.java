package com.example.BookMyShowBackend.Services;

import com.example.BookMyShowBackend.Entities.Show;
import com.example.BookMyShowBackend.Entities.ShowSeat;
import com.example.BookMyShowBackend.Entities.Ticket;
import com.example.BookMyShowBackend.Entities.User;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.TicketRepository;
import com.example.BookMyShowBackend.Repository.UserRepository;
import com.example.BookMyShowBackend.Requests.BookTicketRequest;
import com.example.BookMyShowBackend.Responses.ViewTicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;


    public String bookTicket(BookTicketRequest bookTicketRequest) throws Exception{
        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();

        User user =  userRepository.findByEmailId(bookTicketRequest.getUserEmailId());

        List<ShowSeat> showSeatList = show.getShowSeatList();
        int totalBill = 0;

        for(String seatNoToBeBooked : bookTicketRequest.getSeatList()){

            for(ShowSeat showSeat:showSeatList){

                if(showSeat.getSeatNo().equals(seatNoToBeBooked)){

                    if(showSeat.isAvailable()){
                        showSeat.setAvailable(Boolean.FALSE);
                        totalBill += showSeat.getPrice();

                        if(bookTicketRequest.getFoodSelected().equals("YES")){
                            totalBill+=123;
                            showSeat.setFoodAttached(Boolean.TRUE);
                        }

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
                .user(user)
                .build();

        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);
        ticket = ticketRepository.save(ticket);

        return "Ticket for the movie: "+ show.getMovie().getMovieName() +" has been booked with the ticket Id: "+ticket.getTicketId()+" and total bill generated if of Rs." + ticket.getTotalAmountPaid();
    }

    public ViewTicketResponse viewTicket(int ticketId){

        Ticket ticket = ticketRepository.findById(ticketId).get();

        Show show = ticket.getShow();

        String movieName = show.getMovie().getMovieName();

        int totalAmountPaid = ticket.getTotalAmountPaid();

        String seatNosBooked = ticket.getSeatNosBooked();

        LocalDate showDate = show.getShowDate();
        LocalTime showTime = show.getShowTime();

        String theatreName = show.getTheatre().getName();

        ViewTicketResponse viewTicketResponse = ViewTicketResponse.builder()
                .ticketId(ticketId)
                .movieName(movieName)
                .theatreName(theatreName)
                .showDate(showDate)
                .showTime(showTime)
                .seatNosBooked(seatNosBooked)
                .totalAmountPaid(totalAmountPaid)
                .build();

        return viewTicketResponse;

    }

}
